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
        //)

        //think about putting in super.getX() or super.getY() for a point
        return null;
	}
}
