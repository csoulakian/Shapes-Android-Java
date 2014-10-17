package edu.luc.etl.cs313.android.shapes.model;

import java.util.Collections;
import java.util.List;

/**
 * A shape visitor for calculating the bounding box, that is, the smallest
 * rectangle containing the shape. The resulting bounding box is returned as a
 * rectangle at a specific location.
 */
public class BoundingBox implements Visitor<Location> {

	// TODO entirely your job (except onCircle)

	@Override
	public Location onCircle(final Circle c) {
		final int radius = c.getRadius();
        int x = -radius;
        int y = -radius;
		return new Location(x, y, new Rectangle(2 * radius, 2 * radius));
	}

	@Override
	public Location onFill(final Fill f) {
        return f.getShape().accept(this);
	}

	@Override
	public Location onGroup(final Group g) {
        int n = 0;
        Size h = new Size();
        int[] xVal = new int[h.onGroup(g).intValue()];
        int[] yVal = new int[h.onGroup(g).intValue()];
        for (Shape s : g.getShapes()) {
            xVal[n] = s.accept(this).getX();
            yVal[n] = s.accept(this).getY();
            n++;
        }

        int xMin = xVal[0], xMax = xVal[0];
        int yMin = yVal[0], yMax = yVal[0];
        for (int k = 1; k < n; k++) {
            if (xVal[k] < xMin) {
                xMin = xVal[k];
            }
            if (xVal[k] > xMax) {
                xMax = xVal[k];
            }
            if (yVal[k] < yMin) {
                yMin = yVal[k];
            }
            if (yVal[k] > yMax) {
                yMax = yVal[k];
            }

        }
        return new Location(xMin, yMin, new Rectangle(xMax-xMin, yMax-yMin));
    }

	@Override
	public Location onLocation(final Location l) {
        //return new Location(l.getX(), l.getY(),
        //        new Rectangle(((Rectangle) l.shape).getWidth(), ((Rectangle) l.shape).getHeight()));
        return new Location(l.getX(), l.getY(),
                new Rectangle(l.getShape().accept(this).getX(), l.getShape().accept(this).getY()));
	}

	@Override
	public Location onRectangle(final Rectangle r) {
        return new Location(0, 0, new Rectangle(r.width, r.height));
	}

	@Override
	public Location onStroke(final Stroke c) {
        return c.getShape().accept(this);
	}

	@Override
	public Location onOutline(final Outline o) {
        return o.getShape().accept(this);
	}

	@Override
	public Location onPolygon(final Polygon s) {

        //casting the resulting array from s.getPoints().toArray()
        //(which is type Object) to the type Point
        //left side of = initializes the array of points to a variable points
        Point[] points = (Point[]) s.getPoints().toArray();
        int i = 0;
        int[] xValues = new int[points.length], yValues = new int[points.length];
        //adds all the x point values to xValues array
        //does same for y point values
        for (Point point : points){
            xValues[i] = point.getX();
            yValues[i] = point.getY();
            i++;
        }

        //finds min and max in each of the 2 arrays
        int xMin = xValues[0], xMax = xValues[0];
        int yMin = yValues[0], yMax = yValues[0];
        for (int k = 1; k < i; k++) {
            if (xValues[k] < xMin) {
                xMin = xValues[k];
            }
            if (xValues[k] > xMax) {
                xMax = xValues[k];
            }
            if (yValues[k] < yMin) {
                yMin = yValues[k];
            }
            if (yValues[k] > yMax) {
                yMax = yValues[k];
            }
        }
        int x = xMin;
        int y = yMin;
        return new Location(xMin, yMin, new Rectangle(xMax-xMin, yMax-yMin));
	}
}
