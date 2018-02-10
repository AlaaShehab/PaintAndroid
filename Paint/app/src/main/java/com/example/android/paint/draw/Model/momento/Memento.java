package com.example.android.paint.draw.Model.momento;

/**
 * @author saraheldafrawy
 * stores the moment
 */
public class Memento {

	/**The shape stored in memento Object.
  */
	private TwoShapes twoShapes;
	/**Save a new shape String to the memento Object.
	 * @param shapeSave is the parameter for the saved moment
  */
	public Memento(final TwoShapes shapeSave) {
		this.twoShapes = shapeSave;
	}
	/**@return the value stored in article.
  */
	public final TwoShapes getSavedShape() {
		return this.twoShapes;
	}

}
