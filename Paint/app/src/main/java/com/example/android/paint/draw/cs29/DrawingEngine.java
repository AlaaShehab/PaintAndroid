package eg.edu.alexu.csd.oop.draw.cs29;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.Circle;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.Ellipse;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.Rectangle;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.Square;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.Triangle;
import eg.edu.alexu.csd.oop.draw.cs29.Model.momento.CareTaker;
import eg.edu.alexu.csd.oop.draw.cs29.Model.momento.Originator;
import eg.edu.alexu.csd.oop.draw.cs29.Model.momento.TwoShapes;

/**
 * @author SarahEldafrawy & YoumnaDwidar
 */
public class DrawingEngine implements eg.edu.alexu.csd.oop.draw.DrawingEngine {

  /** pointer to listOfShapes. */
  private ArrayList<Shape> listOfShapes;
  /** pointer to listOfSupportedClasses. */
  private List<Class<? extends Shape>> listOfSupportedClasses;
  /** pointer to originator. */
  private Originator originator;
  /** pointer to careTaker. */
  private CareTaker careTaker;
  /** saves current position, and last position in CareTaker. */
  private int currentIndexSaved = -1, indexRedoStackRemover;
  /** history limit. */
  private final int limitCareTaker = 19;

  /**
   * Constructor.
   */
  public DrawingEngine() {
    listOfShapes = new ArrayList<>();
    originator = new Originator();
    careTaker = new CareTaker();
    listOfSupportedClasses = new ArrayList<>();
    listOfSupportedClasses.add(Circle.class);
    listOfSupportedClasses.add(LineSegment.class);
    listOfSupportedClasses.add(Ellipse.class);
    listOfSupportedClasses.add(Rectangle.class);
    listOfSupportedClasses.add(Triangle.class);
    listOfSupportedClasses.add(Square.class);
  }

  /**
   * redraw shapes on canvas.
   */
  @Override
  public final void refresh(final Graphics canvas) {
    for (int i = 0; i < listOfShapes.size(); i++) {
      listOfShapes.get(i).draw(canvas);
    }
  }

  /**
   * add a new shape in listOfShapes. to draw it later on canvas
   */
  @Override
  public final void addShape(final Shape shape) {
    listOfShapes.add(shape);
    originator.set(new TwoShapes(null, shape));
    if (currentIndexSaved != limitCareTaker) {
      currentIndexSaved++;
    }
    careTaker.addMemento(currentIndexSaved, originator.storeInMemento());
    indexRedoStackRemover = currentIndexSaved;
  }

  /**
   * delete shape operation by removing it from listOfShapes.
   */
  @Override
  public final void removeShape(final Shape shape) {
    listOfShapes.remove(shape);
    originator.set(new TwoShapes(shape, null));
    if (currentIndexSaved != limitCareTaker) {
      currentIndexSaved++;
    }
    careTaker.addMemento(currentIndexSaved, originator.storeInMemento());
    indexRedoStackRemover = currentIndexSaved;
  }

  /**
   * update shape properties operation in listOfShapes.
   */
  @Override
  public final void updateShape(final Shape oldShape, final Shape newShape) {
    listOfShapes.set(listOfShapes.indexOf(oldShape), newShape);
    originator.set(new TwoShapes(oldShape, newShape));
    if (currentIndexSaved != limitCareTaker) {
      currentIndexSaved++;
    }
    careTaker.addMemento(currentIndexSaved, originator.storeInMemento());
    indexRedoStackRemover = currentIndexSaved;
  }

  /**
   * return all shapes draw on canvas.
   */
  @Override
  public final Shape[] getShapes() {
    Shape[] shapes = listOfShapes.toArray(new Shape[0]);
    return shapes;
  }

  /**
   * to return all supported shapes by the program.
   */
  @Override
  public final List<Class<? extends Shape>> getSupportedShapes() {
    return listOfSupportedClasses;
  }

  /**
   * undo the last performed operation.
   */
  @Override
  public final void undo() {
    if (currentIndexSaved == -1) {
      return;
    }

    TwoShapes tS = originator.restoreFromMemento(
        careTaker.getMemento(currentIndexSaved--));

    if (tS.getNewShape() == null) {
      listOfShapes.add(tS.getOldShape());
    } else if (tS.getOldShape() == null) {
      listOfShapes.remove(tS.getNewShape());
    } else {
      listOfShapes.set(
          listOfShapes.indexOf(tS.getNewShape()), tS.getOldShape());
    }
  }

  /**
   * redo function to redo steps performed on canvas.
   */
  @Override
  public final void redo() {
    if (currentIndexSaved == indexRedoStackRemover) {
      return;
    }

    TwoShapes tS = originator.restoreFromMemento(
        careTaker.getMemento(++currentIndexSaved));

    if (tS.getOldShape() == null) {
      listOfShapes.add(tS.getNewShape());
    } else if (tS.getNewShape() == null) {
      listOfShapes.remove(tS.getOldShape());
    } else {
      listOfShapes.set(
          listOfShapes.indexOf(tS.getOldShape()), tS.getNewShape());
    }
  }

  /**
   * @param clss
   *          to add plugin classes.
   */
  public final void addSupportedShapes(final Class<? extends Shape> clss) {
    listOfSupportedClasses.add(clss);
  }

  // missing Jason
  /**
   * save listOfShapes.
   */
  @Override
  public final void save(final String path) {

    Save s = new Save();
    try {
      s.saveXML(path, listOfShapes);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * load last save operation (Xml or Jason).
   */
  @Override
  public final void load(final String path) {

    Load load = new Load();

    listOfShapes = new ArrayList<>(load.loadXML(path));

    currentIndexSaved = -1;
    indexRedoStackRemover = currentIndexSaved;

  }

}
