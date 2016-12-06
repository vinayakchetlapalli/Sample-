
/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;


import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


public class ShowProcResponse implements IndexedRecord {

    private static final Schema schema$ = SchemaBuilder
            .record("ShowProcResponse")
            .namespace("com.gpudb")
            .fields()
                .name("procNames").type().array().items().stringType().noDefault()
                .name("files").type().array().items().map().values().bytesType().noDefault()
                .name("commands").type().array().items().stringType().noDefault()
                .name("args").type().array().items().array().items().stringType().noDefault()
                .name("additionalInfo").type().array().items().map().values().stringType().noDefault()
            .endRecord();


    public static Schema getClassSchema() {
        return schema$;
    }


    public static final class AdditionalInfo {

        public static final String NONDISTRIBUTED = "nondistributed";

        public static final String TRUE = "true";

        public static final String FALSE = "false";


        private AdditionalInfo() {  }
    }


    private List<String> procNames;
    private List<Map<String, ByteBuffer>> files;
    private List<String> commands;
    private List<List<String>> args;
    private List<Map<String, String>> additionalInfo;


    public ShowProcResponse() {
    }

    public List<String> getProcNames() {
        return procNames;
    }

    public ShowProcResponse setProcNames(List<String> procNames) {
        this.procNames = (procNames == null) ? new ArrayList<String>() : procNames;
        return this;
    }

    public List<Map<String, ByteBuffer>> getFiles() {
        return files;
    }

    public ShowProcResponse setFiles(List<Map<String, ByteBuffer>> files) {
        this.files = (files == null) ? new ArrayList<Map<String, ByteBuffer>>() : files;
        return this;
    }

    public List<String> getCommands() {
        return commands;
    }

    public ShowProcResponse setCommands(List<String> commands) {
        this.commands = (commands == null) ? new ArrayList<String>() : commands;
        return this;
    }

    public List<List<String>> getArgs() {
        return args;
    }

    public ShowProcResponse setArgs(List<List<String>> args) {
        this.args = (args == null) ? new ArrayList<List<String>>() : args;
        return this;
    }

    public List<Map<String, String>> getAdditionalInfo() {
        return additionalInfo;
    }

    public ShowProcResponse setAdditionalInfo(List<Map<String, String>> additionalInfo) {
        this.additionalInfo = (additionalInfo == null) ? new ArrayList<Map<String, String>>() : additionalInfo;
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
                return this.procNames;

            case 1:
                return this.files;

            case 2:
                return this.commands;

            case 3:
                return this.args;

            case 4:
                return this.additionalInfo;

            default:
                throw new IndexOutOfBoundsException("Invalid index specified.");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void put(int index, Object value) {
        switch (index) {
            case 0:
                this.procNames = (List<String>)value;
                break;

            case 1:
                this.files = (List<Map<String, ByteBuffer>>)value;
                break;

            case 2:
                this.commands = (List<String>)value;
                break;

            case 3:
                this.args = (List<List<String>>)value;
                break;

            case 4:
                this.additionalInfo = (List<Map<String, String>>)value;
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

        ShowProcResponse that = (ShowProcResponse)obj;

        return ( this.procNames.equals( that.procNames )
                 && this.files.equals( that.files )
                 && this.commands.equals( that.commands )
                 && this.args.equals( that.args )
                 && this.additionalInfo.equals( that.additionalInfo ) );
    }


    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "procNames" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.procNames ) );
        builder.append( ", " );
        builder.append( gd.toString( "files" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.files ) );
        builder.append( ", " );
        builder.append( gd.toString( "commands" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.commands ) );
        builder.append( ", " );
        builder.append( gd.toString( "args" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.args ) );
        builder.append( ", " );
        builder.append( gd.toString( "additionalInfo" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.additionalInfo ) );
        builder.append( "}" );

        return builder.toString();
    }


    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + this.procNames.hashCode();
        hashCode = (31 * hashCode) + this.files.hashCode();
        hashCode = (31 * hashCode) + this.commands.hashCode();
        hashCode = (31 * hashCode) + this.args.hashCode();
        hashCode = (31 * hashCode) + this.additionalInfo.hashCode();
        return hashCode;
    }


}
