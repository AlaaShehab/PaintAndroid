package eg.edu.alexu.csd.oop.draw.cs29.Model.momento;

import eg.edu.alexu.csd.oop.draw.Shape;

/**
 * Stores two shapes to be passed as a moment.
 */
public class TwoShapes {
  /**
   * shapes variables.
   */
  private Shape oldShape, newShape;

  /**
   *
   * @return old Shape
   */
  public final Shape getOldShape() {
    return oldShape;
  }

  /**
   *
   * @return new Shape
   */
  public final Shape getNewShape() {
    return newShape;
  }

  /**
   * @param oldShp stores old shape
   * @param newShp stores new shape
   */
  public TwoShapes(final Shape oldShp, final Shape newShp) {
    this.oldShape = oldShp;
    this.newShape = newShp;
  }

}
