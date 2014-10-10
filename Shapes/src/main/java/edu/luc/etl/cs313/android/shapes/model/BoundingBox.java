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
		return new Location(-radius, -radius, new Rectangle(2 * radius, 2 * radius));
	}

	@Override
	public Location onFill(final Fill f) {
		return null;
	}

	@Override
	public Location onGroup(final Group g) {

		return null;
	}

	@Override
	public Location onLocation(final Location l) {

		return null;
	}

	@Override
	public Location onRectangle(final Rectangle r) {
		return null;
	}

	@Override
	public Location onStroke(final Stroke c) {
		return null;
	}

	@Override
	public Location onOutline(final Outline o) {
		return null;
	}

	@Override
	public Location onPolygon(final Polygon s) {
		//final List<? extends Point> points = s.getPoints();
        //int m = Collections.max(points);
        //for (int i : points.get(i))(
            //Point q = points.get(i);
        //think about putting in super.getX() or super.getY() for a point


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

        return new Location(xMin, yMin, new Rectangle(xMax-xMin, yMax-yMin));
	}
}
