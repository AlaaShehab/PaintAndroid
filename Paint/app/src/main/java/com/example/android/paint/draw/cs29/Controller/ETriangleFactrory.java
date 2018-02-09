package eg.edu.alexu.csd.oop.draw.cs29.Controller;

import java.awt.event.MouseEvent;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.Triangle;

public class ETriangleFactrory implements MouseDraw {

	Triangle tr = new Triangle();

	@Override
	public void mousePressedFun(MouseEvent e) {
			tr.setPosition(e.getPoint());
			tr.getProperties().put("point0x", (double) e.getX());
			tr.getProperties().put("point0y", (double) e.getY());
			tr.getProperties().put("point1x", (double) e.getX());
			tr.getProperties().put("point1y", (double) e.getY());
		
	}

	@Override
	public void mouseReleasedFun(MouseEvent e, DrawingEngine drawEngine) {
		
		tr.getProperties().put("point0x", (double) e.getX());
		tr.getProperties().put("point0y", (double) e.getY());

		double point1x = e.getPoint().distance(tr.getPosition()) - Math.pow(tr.getPosition().getY() - e.getY(), 2);
		tr.getProperties().put("point1x", (double) Math.sqrt(point1x));
		tr.getProperties().put("point1y", (double) e.getY());
    drawEngine.addShape(tr);
		
		
	}
	@Override
	public void mouseDraggedFun(MouseEvent e) {
		tr.getProperties().put("point0x", (double) e.getX());
		tr.getProperties().put("point0y", (double) e.getY());
		
		
		double point1x = e.getPoint().distance(tr.getPosition()) - Math.pow(tr.getPosition().getY() - e.getY() , 2);
		tr.getProperties().put("point1x", (double) Math.sqrt(point1x));
		tr.getProperties().put("point1y", (double) e.getY());
	}

	@Override
	public eg.edu.alexu.csd.oop.draw.Shape Shape() {
		// TODO Auto-generated method stub
		return null;
	}

}
