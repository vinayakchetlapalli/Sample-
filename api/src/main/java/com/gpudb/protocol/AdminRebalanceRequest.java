
/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


public class AdminRebalanceRequest implements IndexedRecord {

    private static final Schema schema$ = SchemaBuilder
            .record("AdminRebalanceRequest")
            .namespace("com.gpudb")
            .fields()
                .name("tableNames").type().array().items().stringType().noDefault()
                .name("options").type().map().values().stringType().noDefault()
            .endRecord();


    public static Schema getClassSchema() {
        return schema$;
    }


    private List<String> tableNames;
    private Map<String, String> options;


    public AdminRebalanceRequest() {
        tableNames = new ArrayList<>();
        options = new LinkedHashMap<>();
    }

    public AdminRebalanceRequest(List<String> tableNames, Map<String, String> options) {
        this.tableNames = (tableNames == null) ? new ArrayList<String>() : tableNames;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    public List<String> getTableNames() {
        return tableNames;
    }

    public AdminRebalanceRequest setTableNames(List<String> tableNames) {
        this.tableNames = (tableNames == null) ? new ArrayList<String>() : tableNames;
        return this;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public AdminRebalanceRequest setOptions(Map<String, String> options) {
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
        return this;
    }

    @Override
    public Schema getSchema() {
        return schema$;
    }

    @Override
    public Object get(int index) {
        switch (index) {
            case 0:
                return this.tableNames;

            case 1:
                return this.options;

            default:
                throw new IndexOutOfBoundsException("Invalid index specified.");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void put(int index, Object value) {
        switch (index) {
            case 0:
                this.tableNames = (List<String>)value;
                break;

            case 1:
                this.options = (Map<String, String>)value;
                break;

            default:
                throw new IndexOutOfBoundsException("Invalid index specified.");
        }
    }


    @Override
    public boolean equals(Object obj) {
        if( obj == this ) {
            return true;
        }

        if( (obj == null) || (obj.getClass() != this.getClass()) ) {
            return false;
        }

        AdminRebalanceRequest that = (AdminRebalanceRequest)obj;

        return ( this.tableNames.equals( that.tableNames )
                 && this.options.equals( that.options ) );
    }


    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "tableNames" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.tableNames ) );
        builder.append( ", " );
        builder.append( gd.toString( "options" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.options ) );
        builder.append( "}" );

        return builder.toString();
    }


    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + this.tableNames.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }


}
