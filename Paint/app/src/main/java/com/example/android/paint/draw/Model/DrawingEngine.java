package com.example.android.paint.draw.Model;

import android.graphics.Canvas;

import com.example.android.paint.draw.Shape;
import com.example.android.paint.draw.Model.momento.CareTaker;
import com.example.android.paint.draw.Model.momento.Originator;
import com.example.android.paint.draw.Model.momento.TwoShapes;

import java.util.ArrayList;

/**
 * @author SarahEldafrawy
 */
public class DrawingEngine implements com.example.android.paint.draw.DrawingEngine {

  /** pointer to listOfShapes. */
  private ArrayList<Shape> listOfShapes;
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
   * save listOfShapes.
   */
  @Override
  public final void save(final String path) {

  //TODO save function
  }

  /**
   * load last save operation (Xml or Jason).
   */
  @Override
  public final void load(final String path) {

    //TODO Load function

    /*memento*/
    currentIndexSaved = -1;
    indexRedoStackRemover = currentIndexSaved;

  }

}
