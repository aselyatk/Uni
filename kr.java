import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;  //библиотека

public class kr {
    public static void main(String[] args) throws IOException {
        // создаем объект класса Iraio и вызываем метод для записи информации в файл
        Iraio iraio = new Iraio();
        iraio.writeInformationToFile();

        // создаем объект класса TrainSchedule и вызываем метод для чтения информации из файла
        TrainSchedule schedule = new TrainSchedule();
        schedule.readInformationFromFile();

        // выводим список поездов на экран
        List<Train> trains = schedule.getTrains();
        System.out.println("Список поездов:");
        for (Train train : trains) {
            System.out.println(train);
        }
    }
}

class Iraio {
    public void writeInformationToFile() throws IOException {
        Path path = Paths.get("source.txt");

        // записываем информацию в файл
        List<String> lines = Arrays.asList(
                "1;101;Moscow;2023-04-22,2023-04-24;08:00;S",
                "2;102;St. Petersburg;2023-04-23;12:30;A",
                "3;103;Kazan;2023-04-25,2023-04-26;16:45;B"
        );
        Files.write(path, lines);
    }
}

class TrainSchedule {
    private List<Train> trains;

    public TrainSchedule() {
        trains = new ArrayList<>();
    }

    public void readInformationFromFile() throws IOException {
        Path sourcePath = Paths.get("source.txt");
        Path archivePath = Paths.get("archive_" + LocalDateTime.now().toString().replace(':', '-') + ".txt");

        // копирование и удаление исходного файла
        Files.copy(sourcePath, archivePath);
        Files.delete(sourcePath);

        // создание списка поездов и чтение информации из файла
        Scanner scanner = new Scanner(archivePath);
        while (scanner.hasNextLine()) {
            String[] trainInfo = scanner.nextLine().split(";");
            int ticketNumber = Integer.parseInt(trainInfo[0]);
            int trainNumber = Integer.parseInt(trainInfo[1]);
            String destination = trainInfo[2];
            LocalDate[] dates = Arrays.stream(trainInfo[3].split(","))
                    .map(LocalDate::parse)
                    .toArray(LocalDate[]::new);
            LocalTime departureTime = LocalTime.parse(trainInfo[4]);
            String seatType = trainInfo[5];

            trains.add(new Train(ticketNumber, trainNumber, destination, dates, departureTime, seatType));
        }
        scanner.close();
    }

    public List<Train> getTrains() {
        return trains;
    }
}

class Train {
    private int ticketNumber;
    private int trainNumber;
    private String destination;
    private LocalDate[] dates
            ;
    private LocalTime departureTime;
    private String seatType;

    public Train(int ticketNumber, int trainNumber, String destination, LocalDate[] dates,
                 LocalTime departureTime, String seatType) {
        this.ticketNumber = ticketNumber;
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.dates = dates;
        this.departureTime = departureTime;
        this.seatType = seatType;
    }

    public Train() {
        this(0, 0, "", new LocalDate[0], null, "");
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;

    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate[] getDates() {
        return dates;
    }

    public void setDates(LocalDate[] dates) {
        this.dates = dates;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;

    }

    @Override
    public String toString() {
        return "Train{" +
                "ticketNumber=" + ticketNumber +
                ", trainNumber=" + trainNumber +
                ", destination='" + destination + '\'' +
                ", dates=" + Arrays.toString(dates) +
                ", departureTime=" + departureTime +
                ", seatType='" + seatType + '\'' +
                '}';
    }
}
