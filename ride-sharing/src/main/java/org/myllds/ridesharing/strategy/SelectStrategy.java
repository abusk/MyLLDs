package org.myllds.ridesharing.strategy;

import org.myllds.ridesharing.model.RideDetails;

public interface SelectStrategy {
    RideDetails select(String source, String destination);
}
