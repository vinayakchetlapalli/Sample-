/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of parameters for {@link com.gpudb.GPUdb#createType(CreateTypeRequest)}.
 * <br />
 * <br />Creates a new type describing the layout or schema of a table. The type definition is a JSON string describing the fields
 * (i.e. columns) of the type. Each field consists of a name and a data type. Supported data types are: double, float, int, long,
 * string, and bytes. In addition one or more properties can be specified for each column which customize the memory usage and query
 * availability of that column.  Note that some properties are mutually exclusive--i.e. they cannot be specified for any given
 * column simultaneously.  One example of mutually exclusive properties are {@code data} and {@code store_only}.
 * <br />
 * <br />To set a *primary key* on one or more columns include the property 'primary_key' on the desired column_names. If a primary
 * key is specified, then a uniqueness constraint is enforced, in that only a single object can exist with a given primary key. When
 * {@link com.gpudb.GPUdb#insertRecordsRaw(RawInsertRecordsRequest) inserting} data into a table with a primary key, depending on
 * the parameters in the request, incoming objects with primary keys that match existing objects will either overwrite (i.e. update)
 * the existing object or will be skipped and not added into the set.
 * <br />
 * <br />Example of a type definition with some of the parameters::
 * <br />
 * <br />  {"type":"record",
 * <br />  "name":"point",
 * <br />  "fields":[{"name":"msg_id","type":"string"},
 * <br />                  {"name":"x","type":"double"},
 * <br />                  {"name":"y","type":"double"},
 * <br />                  {"name":"TIMESTAMP","type":"double"},
 * <br />                  {"name":"source","type":"string"},
 * <br />                  {"name":"group_id","type":"string"},
 * <br />                  {"name":"OBJECT_ID","type":"string"}]
 * <br />  }
 * <br />
 * <br />Properties::
 * <br />
 * <br />  {"group_id":["store_only"],
 * <br />  "msg_id":["store_only","text_search"]
 * <br />  }
 */
public class CreateTypeRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("CreateTypeRequest")
            .namespace("com.gpudb")
            .fields()
                .name("typeDefinition").type().stringType().noDefault()
                .name("label").type().stringType().noDefault()
                .name("properties").type().map().values().array().items().stringType().noDefault()
                .name("options").type().map().values().stringType().noDefault()
            .endRecord();


    /**
     * This method supports the Avro framework and is not intended to be called directly by the user.
     * 
     * @return  the schema for the class.
     * 
     */
    public static Schema getClassSchema() {
        return schema$;
    }


    /**
     * Each key-value pair specifies the properties to use for a given column where the key is the column name.  All keys used must
     * be relevant column names for the given table.  Specifying any property overrides the default properties for that column
     * (which is based on the column's data type).
     * <br />A set of string constants for the parameter {@code properties}.
     */
    public static final class Properties {

        /**
         * Default property for all numeric and string type columns; makes the column available for GPU queries.
         */
        public static final String DATA = "data";

        /**
         * Valid only for 'string' columns. Enables full text search for string columns. Can be set independently of *data* and
         * *store_only*.
         */
        public static final String TEXT_SEARCH = "text_search";

        /**
         * Persist the column value but do not make it available to queries (e.g. {@link
         * com.gpudb.GPUdb#filterByBox(FilterByBoxRequest)})-i.e. it is mutually exclusive to the 'data' property. Any 'bytes' type
         * column must have a 'store_only' property. This property reduces system memory usage.
         */
        public static final String STORE_ONLY = "store_only";

        /**
         * Works in conjunction with the 'data' property for string columns. This property reduces system disk usage by disabling
         * reverse string lookups. Queries like {@link com.gpudb.GPUdb#filter(FilterRequest)}, {@link
         * com.gpudb.GPUdb#filterByList(FilterByListRequest)}, and {@link com.gpudb.GPUdb#filterByValue(FilterByValueRequest)} work
         * as usual but {@link com.gpudb.GPUdb#aggregateUniqueRaw(AggregateUniqueRequest)}, {@link
         * com.gpudb.GPUdb#aggregateGroupByRaw(AggregateGroupByRequest)} and {@link
         * com.gpudb.GPUdb#getRecordsByColumnRaw(GetRecordsByColumnRequest)} are not allowed on columns with this property.
         */
        public static final String DISK_OPTIMIZED = "disk_optimized";

        /**
         * Valid only for 'long' columns. Indicates that this field represents a timestamp and will be provided in milliseconds
         * since the Unix epoch: 00:00:00 Jan 1 1970.  Dates represented by a timestamp must fall between the year 1000 and the year
         * 2900.
         */
        public static final String TIMESTAMP = "timestamp";

        /**
         * Valid only for 'string' columns.  It represents a SQL type NUMERIC(19, 4) data type.  There can be up to 15 digits before
         * the decimal point and up to four digits in the fractional part.  The value can be positive or negative (indicated by a
         * minus sign at the beginning).  This property is mutually exclusive with the 'text_search' property.
         */
        public static final String DECIMAL = "decimal";

        /**
         * Valid only for 'string' columns.  Indicates that this field represents a date and will be provided in the format
         * 'YYYY-MM-DD'.  The allowable range is 1000-01-01 through 2900-01-01.
         */
        public static final String DATE = "date";

        /**
         * Valid only for 'string' columns.  Indicates that this field represents a time-of-day and will be provided in the format
         * 'HH:MM:SS.mmm'.  The allowable range is 00:00:00.000 through 23:59:59.999.
         */
        public static final String TIME = "time";

        /**
         * This property provides optimized memory, disk and query performance for string columns. Strings with this property must
         * be no longer than 1 character. This property cannot be combined with *text_search*
         */
        public static final String CHAR1 = "char1";

        /**
         * This property provides optimized memory, disk and query performance for string columns. Strings with this property must
         * be no longer than 2 characters. This property cannot be combined with *text_search*
         */
        public static final String CHAR2 = "char2";

        /**
         * This property provides optimized memory, disk and query performance for string columns. Strings with this property must
         * be no longer than 4 characters. This property cannot be combined with *text_search*
         */
        public static final String CHAR4 = "char4";

        /**
         * This property provides optimized memory, disk and query performance for string columns. Strings with this property must
         * be no longer than 8 characters. This property cannot be combined with *text_search*
         */
        public static final String CHAR8 = "char8";

        /**
         * This property provides optimized memory, disk and query performance for string columns. Strings with this property must
         * be no longer than 16 characters. This property cannot be combined with *text_search*
         */
        public static final String CHAR16 = "char16";

        /**
         * This property provides optimized memory, disk and query performance for string columns. Strings with this property must
         * be no longer than 32 characters. This property cannot be combined with *text_search*
         */
        public static final String CHAR32 = "char32";

        /**
         * This property provides optimized memory, disk and query performance for string columns. Strings with this property must
         * be no longer than 64 characters. This property cannot be combined with *text_search*
         */
        public static final String CHAR64 = "char64";

        /**
         * This property provides optimized memory, disk and query performance for string columns. Strings with this property must
         * be no longer than 128 characters. This property cannot be combined with *text_search*
         */
        public static final String CHAR128 = "char128";

        /**
         * This property provides optimized memory, disk and query performance for string columns. Strings with this property must
         * be no longer than 256 characters. This property cannot be combined with *text_search*
         */
        public static final String CHAR256 = "char256";

        /**
         * This property provides optimized memory and query performance for int columns. Ints with this property must be between
         * -128 and +127 (inclusive)
         */
        public static final String INT8 = "int8";

        /**
         * This property provides optimized memory and query performance for int columns. Ints with this property must be between
         * -32768 and +32767 (inclusive)
         */
        public static final String INT16 = "int16";

        /**
         * This property provides optimized memory, disk and query performance for string columns representing IPv4 addresses (i.e.
         * 192.168.1.1). Strings with this property must be of the form: A.B.C.D where A, B, C and D are in the range of 0-255.
         */
        public static final String IPV4 = "ipv4";

        /**
         * This property indicates that this column will be part of (or the entire) primary key.
         */
        public static final String PRIMARY_KEY = "primary_key";

        /**
         * This property indicates that this column will be part of (or the entire) shard key.
         */
        public static final String SHARD_KEY = "shard_key";

        /**
         * This property indicates that this column is nullable.  However, setting this property is insufficient for making the
         * column nullable.  The user must declare the type of the column as a union between its regular type and 'null' in the avro
         * schema for the record type in {@code typeDefinition}.  For example, if a column is of type integer and is nullable, then
         * the entry for the column in the avro schema must be: ['int', 'null'].
         * <br />
         * <br />The Java and C++ APIs have built-in convenience for bypassing setting the avro schema by hand.  For those two
         * languages, one can use this property as usual and not have to worry about the avro schema for the record.
         */
        public static final String NULLABLE = "nullable";

        private Properties() {  }
    }

    private String typeDefinition;
    private String label;
    private Map<String, List<String>> properties;
    private Map<String, String> options;


    /**
     * Constructs a CreateTypeRequest object with default parameters.
     */
    public CreateTypeRequest() {
        typeDefinition = "";
        label = "";
        properties = new LinkedHashMap<>();
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs a CreateTypeRequest object with the specified parameters.
     * 
     * @param typeDefinition  a JSON string describing the columns of the type to be registered.
     * @param label  A user-defined description string which can be used to differentiate between tables and types with otherwise
     *               identical schemas.
     * @param properties  Each key-value pair specifies the properties to use for a given column where the key is the column name.
     *                    All keys used must be relevant column names for the given table.  Specifying any property overrides the
     *                    default properties for that column (which is based on the column's data type).
     * @param options  Optional parameters.
     * 
     */
    public CreateTypeRequest(String typeDefinition, String label, Map<String, List<String>> properties, Map<String, String> options) {
        this.typeDefinition = (typeDefinition == null) ? "" : typeDefinition;
        this.label = (label == null) ? "" : label;
        this.properties = (properties == null) ? new LinkedHashMap<String, List<String>>() : properties;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return a JSON string describing the columns of the type to be registered.
     * 
     */
    public String getTypeDefinition() {
        return typeDefinition;
    }

    /**
     * 
     * @param typeDefinition  a JSON string describing the columns of the type to be registered.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public CreateTypeRequest setTypeDefinition(String typeDefinition) {
        this.typeDefinition = (typeDefinition == null) ? "" : typeDefinition;
        return this;
    }

    /**
     * 
     * @return A user-defined description string which can be used to differentiate between tables and types with otherwise
     *         identical schemas.
     * 
     */
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label  A user-defined description string which can be used to differentiate between tables and types with otherwise
     *               identical schemas.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public CreateTypeRequest setLabel(String label) {
        this.label = (label == null) ? "" : label;
        return this;
    }

    /**
     * 
     * @return Each key-value pair specifies the properties to use for a given column where the key is the column name.  All keys
     *         used must be relevant column names for the given table.  Specifying any property overrides the default properties for
     *         that column (which is based on the column's data type).
     * 
     */
    public Map<String, List<String>> getProperties() {
        return properties;
    }

    /**
     * 
     * @param properties  Each key-value pair specifies the properties to use for a given column where the key is the column name.
     *                    All keys used must be relevant column names for the given table.  Specifying any property overrides the
     *                    default properties for that column (which is based on the column's data type).
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public CreateTypeRequest setProperties(Map<String, List<String>> properties) {
        this.properties = (properties == null) ? new LinkedHashMap<String, List<String>>() : properties;
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
    public CreateTypeRequest setOptions(Map<String, String> options) {
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
        return this;
    }

    /**
     * This method supports the Avro framework and is not intended to be called directly by the user.
     * 
     * @return the schema object describing this class.
     * 
     */
    @Override
    public Schema getSchema() {
        return schema$;
    }

    /**
     * This method supports the Avro framework and is not intended to be called directly by the user.
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
                return this.typeDefinition;

            case 1:
                return this.label;

            case 2:
                return this.properties;

            case 3:
                return this.options;

            default:
                throw new IndexOutOfBoundsException("Invalid index specified.");
        }
    }

    /**
     * This method supports the Avro framework and is not intended to be called directly by the user.
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
                this.typeDefinition = (String)value;
                break;

            case 1:
                this.label = (String)value;
                break;

            case 2:
                this.properties = (Map<String, List<String>>)value;
                break;

            case 3:
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

        CreateTypeRequest that = (CreateTypeRequest)obj;

        return ( this.typeDefinition.equals( that.typeDefinition )
                 && this.label.equals( that.label )
                 && this.properties.equals( that.properties )
                 && this.options.equals( that.options ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "typeDefinition" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.typeDefinition ) );
        builder.append( ", " );
        builder.append( gd.toString( "label" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.label ) );
        builder.append( ", " );
        builder.append( gd.toString( "properties" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.properties ) );
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
        hashCode = (31 * hashCode) + this.typeDefinition.hashCode();
        hashCode = (31 * hashCode) + this.label.hashCode();
        hashCode = (31 * hashCode) + this.properties.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}
