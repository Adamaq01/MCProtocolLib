package org.spacehq.mc.protocol.packet.ingame.server.world;

import org.spacehq.mc.protocol.util.ReflectionToString;
import org.spacehq.packetlib.io.NetInput;
import org.spacehq.packetlib.io.NetOutput;
import org.spacehq.packetlib.packet.Packet;

import java.io.IOException;

public class ServerUnloadChunkPacket implements Packet {
    private int x;
    private int z;

    @SuppressWarnings("unused")
    private ServerUnloadChunkPacket() {
    }

    public ServerUnloadChunkPacket(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public int getX() {
        return this.x;
    }

    public int getZ() {
        return this.z;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.x = in.readInt();
        this.z = in.readInt();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeInt(this.x);
        out.writeInt(this.z);
    }

    @Override
    public boolean isPriority() {
        return false;
    }

    @Override
    public String toString() {
        return ReflectionToString.toString(this);
    }
}
