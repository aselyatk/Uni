//import javax.media.j3d.*;
//import javax.media.j3d.BranchGroup;
//import javax.swing.*;
//import javax.vecmath.*;
//import java.awt.*;
//
//
//public class Shape3D extends JFrame {
//
//        public Shape3D() {
//                super("3D Sphere");
//                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                getContentPane().setLayout(new BorderLayout());
//                GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
//                Canvas3D canvas = new Canvas3D(config);
//                getContentPane().add(canvas, BorderLayout.CENTER);
//                BranchGroup scene = createSceneGraph();
//                scene.compile();
//                SimpleUniverse su = new SimpleUniverse(canvas);
//                su.getViewingPlatform().setNominalViewingTransform();
//                su.addBranchGraph(scene);
//                pack();
//                setVisible(true);
//        }
//
//        public BranchGroup createSceneGraph() {
//                BranchGroup root = new BranchGroup();
//                Appearance appearance = new Appearance();
//                appearance.setMaterial(new Material());
//                Sphere sphere = new Sphere(0.5f, Primitive.GENERATE_NORMALS, 100, appearance);
//                root.addChild(sphere);
//                Color3f light1Color = new Color3f(1.0f, 1.0f, 1.0f);
//                BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
//                Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
//                DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
//                light1.setInfluencingBounds(bounds);
//                root.addChild(light1);
//                return root;
//        }
//
//        public static void main(String[] args) {
//                Sphere3D sphere = new Sphere3D();
//        }
//}
