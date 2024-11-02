package oop.streams;

import java.util.Random;

public record TheatreSeat(char rowMarker, int seatNo, boolean isReserved) {
    public TheatreSeat(char rowMarker, int seatNo) {
        this(rowMarker, seatNo, new Random().nextBoolean());
    }


}
