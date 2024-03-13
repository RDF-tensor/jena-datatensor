package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("short")
public class ShortJSONData extends JSONData {
    private short[] data;

    public ShortJSONData() {
        super("short");
    }

    public short[] getData() {
        return data;
    }

    public void setData(short[] data) {
        this.data = data;
    }

}
