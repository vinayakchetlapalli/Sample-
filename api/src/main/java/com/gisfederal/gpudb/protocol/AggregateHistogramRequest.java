/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gisfederal.gpudb.protocol;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of parameters for {@link
 * com.gisfederal.gpudb.GPUdb#aggregateHistogram(AggregateHistogramRequest)}.
 * <p>
 * Performs a histogram calculation given a table, a column, and an interval
 * function. The {@code interval} is used to produce bins of that size and the
 * result, computed over the records falling within each bin, is returned.  For
 * each bin, the start value is inclusive, but the end value is exclusive--
 * except for the very last bin for which the end value is also inclusive.  The
 * value returned for each bin is the number of records in it, except when a
 * column name is provided as a *value_column* in {@code options}.  In this
 * latter case the sum of the values corresponding to the *value_column* is
 * used as the result instead.
 */
public class AggregateHistogramRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("AggregateHistogramRequest")
            .namespace("com.gisfederal.gpudb")
            .fields()
                .name("tableName").type().stringType().noDefault()
                .name("columnName").type().stringType().noDefault()
                .name("start").type().doubleType().noDefault()
                .name("end").type().doubleType().noDefault()
                .name("interval").type().doubleType().noDefault()
                .name("options").type().map().values().stringType().noDefault()
            .endRecord();


    /**
     * This method supports the Avro framework and is not intended to be called
     * directly by the user.
     * 
     * @return  the schema for the class.
     * 
     */
    public static Schema getClassSchema() {
        return schema$;
    }


    /**
     * Optional parameters.
     * A set of string constants for the parameter {@code options}.
     */
    public static final class Options {

        /**
         * The name of the column GPUdb will use when calculating the bin
         * values (values are summed).  The column must be a numerical type
         * (int, double, long, float).
         */
        public static final String VALUE_COLUMN = "value_column";

        private Options() {  }
    }

    private String tableName;
    private String columnName;
    private double start;
    private double end;
    private double interval;
    private Map<String, String> options;


    /**
     * Constructs an AggregateHistogramRequest object with default parameters.
     */
    public AggregateHistogramRequest() {
        tableName = "";
        columnName = "";
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs an AggregateHistogramRequest object with the specified
     * parameters.
     * 
     * @param tableName  Name of the table on which the operation will be
     *                   performed. Must be a valid table or collection in
     *                   GPUdb.
     * @param columnName  Name of a column or an expression of one or more
     *                    column names over which the histogram will be
     *                    calculated.
     * @param start  Lower end value of the histogram interval, inclusive.
     * @param end  Upper end value of the histogram interval, inclusive.
     * @param interval  The size of each bin within the start and end
     *                  parameters.
     * @param options  Optional parameters.
     * 
     */
    public AggregateHistogramRequest(String tableName, String columnName, double start, double end, double interval, Map<String, String> options) {
        this.tableName = (tableName == null) ? "" : tableName;
        this.columnName = (columnName == null) ? "" : columnName;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return Name of the table on which the operation will be performed. Must
     *         be a valid table or collection in GPUdb.
     * 
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName  Name of the table on which the operation will be
     *                   performed. Must be a valid table or collection in
     *                   GPUdb.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AggregateHistogramRequest setTableName(String tableName) {
        this.tableName = (tableName == null) ? "" : tableName;
        return this;
    }

    /**
     * 
     * @return Name of a column or an expression of one or more column names
     *         over which the histogram will be calculated.
     * 
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 
     * @param columnName  Name of a column or an expression of one or more
     *                    column names over which the histogram will be
     *                    calculated.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AggregateHistogramRequest setColumnName(String columnName) {
        this.columnName = (columnName == null) ? "" : columnName;
        return this;
    }

    /**
     * 
     * @return Lower end value of the histogram interval, inclusive.
     * 
     */
    public double getStart() {
        return start;
    }

    /**
     * 
     * @param start  Lower end value of the histogram interval, inclusive.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AggregateHistogramRequest setStart(double start) {
        this.start = start;
        return this;
    }

    /**
     * 
     * @return Upper end value of the histogram interval, inclusive.
     * 
     */
    public double getEnd() {
        return end;
    }

    /**
     * 
     * @param end  Upper end value of the histogram interval, inclusive.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AggregateHistogramRequest setEnd(double end) {
        this.end = end;
        return this;
    }

    /**
     * 
     * @return The size of each bin within the start and end parameters.
     * 
     */
    public double getInterval() {
        return interval;
    }

    /**
     * 
     * @param interval  The size of each bin within the start and end
     *                  parameters.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AggregateHistogramRequest setInterval(double interval) {
        this.interval = interval;
        return this;
    }

    /**
     * 
     * @return Optional parameters.
     * 
     */
    public Map<String, String> getOptions() {
        return options;
    }

    /**
     * 
     * @param options  Optional parameters.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public AggregateHistogramRequest setOptions(Map<String, String> options) {
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
        return this;
    }

    /**
     * This method supports the Avro framework and is not intended to be called
     * directly by the user.
     * 
     * @return the schema object describing this class.
     * 
     */
    @Override
    public Schema getSchema() {
        return schema$;
    }

    /**
     * This method supports the Avro framework and is not intended to be called
     * directly by the user.
     * 
     * @param index  the position of the field to get
     * 
     * @return value of the field with the given index.
     * 
     * @throws IndexOutOfBoundsException
     * 
     */
    @Override
    public Object get(int index) {
        switch (index) {
            case 0:
                return this.tableName;

            case 1:
                return this.columnName;

            case 2:
                return this.start;

            case 3:
                return this.end;

            case 4:
                return this.interval;

            case 5:
                return this.options;

            default:
                throw new IndexOutOfBoundsException("Invalid index specified.");
        }
    }

    /**
     * This method supports the Avro framework and is not intended to be called
     * directly by the user.
     * 
     * @param index  the position of the field to set
     * @param value  the value to set
     * 
     * @throws IndexOutOfBoundsException
     * 
     */
    @Override
    @SuppressWarnings("unchecked")
    public void put(int index, Object value) {
        switch (index) {
            case 0:
                this.tableName = (String)value;
                break;

            case 1:
                this.columnName = (String)value;
                break;

            case 2:
                this.start = (Double)value;
                break;

            case 3:
                this.end = (Double)value;
                break;

            case 4:
                this.interval = (Double)value;
                break;

            case 5:
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

        AggregateHistogramRequest that = (AggregateHistogramRequest)obj;

        return ( this.tableName.equals( that.tableName )
                 && this.columnName.equals( that.columnName )
                 && ( (Double)this.start ).equals( (Double)that.start )
                 && ( (Double)this.end ).equals( (Double)that.end )
                 && ( (Double)this.interval ).equals( (Double)that.interval )
                 && this.options.equals( that.options ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( gd.toString( "tableName" ) );
        builder.append( gd.toString( ":" ) );
        builder.append( gd.toString( this.tableName ) );
        builder.append( gd.toString( "," ) );
        builder.append( gd.toString( "columnName" ) );
        builder.append( gd.toString( ":" ) );
        builder.append( gd.toString( this.columnName ) );
        builder.append( gd.toString( "," ) );
        builder.append( gd.toString( "start" ) );
        builder.append( gd.toString( ":" ) );
        builder.append( gd.toString( this.start ) );
        builder.append( gd.toString( "," ) );
        builder.append( gd.toString( "end" ) );
        builder.append( gd.toString( ":" ) );
        builder.append( gd.toString( this.end ) );
        builder.append( gd.toString( "," ) );
        builder.append( gd.toString( "interval" ) );
        builder.append( gd.toString( ":" ) );
        builder.append( gd.toString( this.interval ) );
        builder.append( gd.toString( "," ) );
        builder.append( gd.toString( "options" ) );
        builder.append( gd.toString( ":" ) );
        builder.append( gd.toString( this.options ) );

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + this.tableName.hashCode();
        hashCode = (31 * hashCode) + this.columnName.hashCode();
        hashCode = (31 * hashCode) + ((Double)this.start).hashCode();
        hashCode = (31 * hashCode) + ((Double)this.end).hashCode();
        hashCode = (31 * hashCode) + ((Double)this.interval).hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}