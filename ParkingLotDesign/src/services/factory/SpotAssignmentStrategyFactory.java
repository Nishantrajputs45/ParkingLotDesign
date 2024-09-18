package services.factory;

import models.SpotAssignmentStrategyType;
import services.strategies.spotassignment.NearestSpotAssignmentStrategy;
import services.strategies.spotassignment.RandomSpotAssignmentStrategy;
import services.strategies.spotassignment.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType){
        switch(spotAssignmentStrategyType){
            case RANDOM :
                return new RandomSpotAssignmentStrategy();
            case NEAREST:
                return new NearestSpotAssignmentStrategy();
            default:
                return null;


        }
    }
}
