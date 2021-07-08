package org.basedbin.server.packet;

import java.io.DataInputStream;

public abstract class Packet {
    public abstract void readPacketData(DataInputStream dataInputStream);
    public abstract void writePacketData(DataInputStream dataInputStream);
    public abstract void getPacketSize();


}
