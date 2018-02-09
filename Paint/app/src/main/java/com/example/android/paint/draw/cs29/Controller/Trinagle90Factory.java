package eg.edu.alexu.csd.oop.draw.cs29.Controller;

import java.awt.event.MouseEvent;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.Triangle;

public class Trinagle90Factory implements MouseDraw {

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
		tr.getProperties().put("point1x", (double) tr.getPosition().getX());
		tr.getProperties().put("point1y", (double) e.getY());
    drawEngine.addShape(tr);
	}

	@Override
	public void mouseDraggedFun(MouseEvent e) {
		
		tr.getProperties().put("point0x", (double) e.getX());
		tr.getProperties().put("point0y", (double) e.getY());
		tr.getProperties().put("point1x", (double) tr.getPosition().getX());
		tr.getProperties().put("point1y", (double) e.getY());
		
		
		
	}

	@Override
	public eg.edu.alexu.csd.oop.draw.Shape Shape() {
		
		return tr;
	}

}
