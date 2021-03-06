/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of results returned by {@link
 * com.gpudb.GPUdb#showTable(ShowTableRequest)}.
 */
public class ShowTableResponse implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("ShowTableResponse")
            .namespace("com.gpudb")
            .fields()
                .name("tableName").type().stringType().noDefault()
                .name("tableNames").type().array().items().stringType().noDefault()
                .name("tableDescriptions").type().array().items().array().items().stringType().noDefault()
                .name("typeIds").type().array().items().stringType().noDefault()
                .name("typeSchemas").type().array().items().stringType().noDefault()
                .name("typeLabels").type().array().items().stringType().noDefault()
                .name("properties").type().array().items().map().values().array().items().stringType().noDefault()
                .name("additionalInfo").type().array().items().map().values().stringType().noDefault()
                .name("sizes").type().array().items().longType().noDefault()
                .name("fullSizes").type().array().items().longType().noDefault()
                .name("joinSizes").type().array().items().doubleType().noDefault()
                .name("totalSize").type().longType().noDefault()
                .name("totalFullSize").type().longType().noDefault()
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
     * List of descriptions for the respective tables in {@code tableNames}.
     * Values: COLLECTION, VIEW, REPLICATED, JOIN, RESULT_TABLE.

     * A set of string constants for the parameter {@code tableDescriptions}.
     */
    public static final class TableDescriptions {
        public static final String COLLECTION = "COLLECTION";
        public static final String VIEW = "VIEW";
        public static final String REPLICATED = "REPLICATED";
        public static final String JOIN = "JOIN";
        public static final String RESULT_TABLE = "RESULT_TABLE";

        private TableDescriptions() {  }
    }


    /**
     * Additional information about the respective tables in {@code
     * tableNames}. Values: .

     * A set of string constants for the parameter {@code additionalInfo}.
     */
    public static final class AdditionalInfo {

        /**
         * Only present if the respective table is a collection. The value
         * indicates whether the collection is allowed to contain multiple
         * tables or views of the same type or not. Values: true, false.
         */
        public static final String ALLOW_HOMOGENEOUS_TABLES = "allow_homogeneous_tables";
        public static final String FALSE = "false";
        public static final String TRUE = "true";

        /**
         * Indicates whether the respective table is protected or not. Values:
         * true, false.
         */
        public static final String PROTECTED = "protected";

        /**
         * The value of TTL setting, in minutes, for the respective table (-1
         * if it will never expire).  This is not the remaining amount of time
         * before the table expires. Not present for collections.
         */
        public static final String TABLE_TTL = "table_ttl";

        /**
         * The remaining amount of minutes before the respective table expires
         * (-1 if it will never expire).  This value may be different from the
         * table's TTL setting. Not present for collections.
         */
        public static final String REMAINING_TABLE_TTL = "remaining_table_ttl";

        /**
         * Semicolon-separated list of foreign key constraints, of the format
         * 'source_column references target_table(primary_key_column)'. Not
         * present for collections.
         */
        public static final String FOREIGN_KEYS = "foreign_keys";

        /**
         * Foreign shard key description of the format: <fk_foreign_key>
         * references <pk_column_name> from <pk_table_name>(<pk_primary_key>).
         * Not present for collections.
         */
        public static final String FOREIGN_SHARD_KEY = "foreign_shard_key";

        /**
         * Semicolon-separated list of columns that have attribute indexes. Not
         * present for collections.
         */
        public static final String ATTRIBUTE_INDEXES = "attribute_indexes";

        private AdditionalInfo() {  }
    }

    private String tableName;
    private List<String> tableNames;
    private List<List<String>> tableDescriptions;
    private List<String> typeIds;
    private List<String> typeSchemas;
    private List<String> typeLabels;
    private List<Map<String, List<String>>> properties;
    private List<Map<String, String>> additionalInfo;
    private List<Long> sizes;
    private List<Long> fullSizes;
    private List<Double> joinSizes;
    private long totalSize;
    private long totalFullSize;


    /**
     * Constructs a ShowTableResponse object with default parameters.
     */
    public ShowTableResponse() {
    }

    /**
     * 
     * @return Value of {@code tableName}.
     * 
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName  Value of {@code tableName}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTableName(String tableName) {
        this.tableName = (tableName == null) ? "" : tableName;
        return this;
    }

    /**
     * 
     * @return If {@code tableName} is a table or view, then the single element
     *         of the array is {@code tableName}. If {@code tableName} is a
     *         collection and {@code show_children} is set to {@code true},
     *         then this array is populated with the names of all tables and
     *         views contained by the given collection; if {@code
     *         show_children} is {@code false} then this array will only
     *         include the collection name itself. If {@code tableName} is an
     *         empty string, then the array contains the names of all
     *         collections and top-level tables.
     * 
     */
    public List<String> getTableNames() {
        return tableNames;
    }

    /**
     * 
     * @param tableNames  If {@code tableName} is a table or view, then the
     *                    single element of the array is {@code tableName}. If
     *                    {@code tableName} is a collection and {@code
     *                    show_children} is set to {@code true}, then this
     *                    array is populated with the names of all tables and
     *                    views contained by the given collection; if {@code
     *                    show_children} is {@code false} then this array will
     *                    only include the collection name itself. If {@code
     *                    tableName} is an empty string, then the array
     *                    contains the names of all collections and top-level
     *                    tables.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTableNames(List<String> tableNames) {
        this.tableNames = (tableNames == null) ? new ArrayList<String>() : tableNames;
        return this;
    }

    /**
     * 
     * @return List of descriptions for the respective tables in {@code
     *         tableNames}. Values: COLLECTION, VIEW, REPLICATED, JOIN,
     *         RESULT_TABLE.
     * 
     */
    public List<List<String>> getTableDescriptions() {
        return tableDescriptions;
    }

    /**
     * 
     * @param tableDescriptions  List of descriptions for the respective tables
     *                           in {@code tableNames}. Values: COLLECTION,
     *                           VIEW, REPLICATED, JOIN, RESULT_TABLE.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTableDescriptions(List<List<String>> tableDescriptions) {
        this.tableDescriptions = (tableDescriptions == null) ? new ArrayList<List<String>>() : tableDescriptions;
        return this;
    }

    /**
     * 
     * @return Type ids of the respective tables in {@code tableNames}.
     * 
     */
    public List<String> getTypeIds() {
        return typeIds;
    }

    /**
     * 
     * @param typeIds  Type ids of the respective tables in {@code tableNames}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTypeIds(List<String> typeIds) {
        this.typeIds = (typeIds == null) ? new ArrayList<String>() : typeIds;
        return this;
    }

    /**
     * 
     * @return Type schemas of the respective tables in {@code tableNames}.
     * 
     */
    public List<String> getTypeSchemas() {
        return typeSchemas;
    }

    /**
     * 
     * @param typeSchemas  Type schemas of the respective tables in {@code
     *                     tableNames}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTypeSchemas(List<String> typeSchemas) {
        this.typeSchemas = (typeSchemas == null) ? new ArrayList<String>() : typeSchemas;
        return this;
    }

    /**
     * 
     * @return Type labels of the respective tables in {@code tableNames}.
     * 
     */
    public List<String> getTypeLabels() {
        return typeLabels;
    }

    /**
     * 
     * @param typeLabels  Type labels of the respective tables in {@code
     *                    tableNames}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTypeLabels(List<String> typeLabels) {
        this.typeLabels = (typeLabels == null) ? new ArrayList<String>() : typeLabels;
        return this;
    }

    /**
     * 
     * @return Property maps of the respective tables in {@code tableNames}.
     * 
     */
    public List<Map<String, List<String>>> getProperties() {
        return properties;
    }

    /**
     * 
     * @param properties  Property maps of the respective tables in {@code
     *                    tableNames}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setProperties(List<Map<String, List<String>>> properties) {
        this.properties = (properties == null) ? new ArrayList<Map<String, List<String>>>() : properties;
        return this;
    }

    /**
     * 
     * @return Additional information about the respective tables in {@code
     *         tableNames}. Values: .
     * 
     */
    public List<Map<String, String>> getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * 
     * @param additionalInfo  Additional information about the respective
     *                        tables in {@code tableNames}. Values: .
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setAdditionalInfo(List<Map<String, String>> additionalInfo) {
        this.additionalInfo = (additionalInfo == null) ? new ArrayList<Map<String, String>>() : additionalInfo;
        return this;
    }

    /**
     * 
     * @return Empty array if the {@code get_sizes} option is {@code false}.
     *         Otherwise, sizes of the respective tables represented in {@code
     *         tableNames}. For all but track data types, this is simply the
     *         number of total objects in a table. For track types, since each
     *         track semantically contains many individual objects, the {@code
     *         sizes} are the counts of conceptual tracks (each of which may be
     *         associated with multiple objects).
     * 
     */
    public List<Long> getSizes() {
        return sizes;
    }

    /**
     * 
     * @param sizes  Empty array if the {@code get_sizes} option is {@code
     *               false}. Otherwise, sizes of the respective tables
     *               represented in {@code tableNames}. For all but track data
     *               types, this is simply the number of total objects in a
     *               table. For track types, since each track semantically
     *               contains many individual objects, the {@code sizes} are
     *               the counts of conceptual tracks (each of which may be
     *               associated with multiple objects).
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setSizes(List<Long> sizes) {
        this.sizes = (sizes == null) ? new ArrayList<Long>() : sizes;
        return this;
    }

    /**
     * 
     * @return Empty array if the {@code get_sizes} option is {@code false}.
     *         Otherwise, number of total objects in the respective tables
     *         represented in {@code tableNames}. For all but track data types,
     *         this is the same as {@code sizes}. For track types, since each
     *         track semantically contains many individual objects, {@code
     *         fullSizes} is the count of total objects.
     * 
     */
    public List<Long> getFullSizes() {
        return fullSizes;
    }

    /**
     * 
     * @param fullSizes  Empty array if the {@code get_sizes} option is {@code
     *                   false}. Otherwise, number of total objects in the
     *                   respective tables represented in {@code tableNames}.
     *                   For all but track data types, this is the same as
     *                   {@code sizes}. For track types, since each track
     *                   semantically contains many individual objects, {@code
     *                   fullSizes} is the count of total objects.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setFullSizes(List<Long> fullSizes) {
        this.fullSizes = (fullSizes == null) ? new ArrayList<Long>() : fullSizes;
        return this;
    }

    /**
     * 
     * @return Empty array if the {@code get_sizes} option is {@code false}.
     *         Otherwise, number of unfiltered objects in the cross product of
     *         the sub-tables in the joined-tables represented in {@code
     *         tableNames}. For simple tables, this number will be the same as
     *         {@code sizes}.  For join-tables this value gives the number of
     *         joined-table rows that must be processed by any aggregate
     *         functions operating on the table.
     * 
     */
    public List<Double> getJoinSizes() {
        return joinSizes;
    }

    /**
     * 
     * @param joinSizes  Empty array if the {@code get_sizes} option is {@code
     *                   false}. Otherwise, number of unfiltered objects in the
     *                   cross product of the sub-tables in the joined-tables
     *                   represented in {@code tableNames}. For simple tables,
     *                   this number will be the same as {@code sizes}.  For
     *                   join-tables this value gives the number of
     *                   joined-table rows that must be processed by any
     *                   aggregate functions operating on the table.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setJoinSizes(List<Double> joinSizes) {
        this.joinSizes = (joinSizes == null) ? new ArrayList<Double>() : joinSizes;
        return this;
    }

    /**
     * 
     * @return -1 if the {@code get_sizes} option is {@code false}. Otherwise,
     *         the sum of the elements of {@code sizes}.
     * 
     */
    public long getTotalSize() {
        return totalSize;
    }

    /**
     * 
     * @param totalSize  -1 if the {@code get_sizes} option is {@code false}.
     *                   Otherwise, the sum of the elements of {@code sizes}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTotalSize(long totalSize) {
        this.totalSize = totalSize;
        return this;
    }

    /**
     * 
     * @return -1 if the {@code get_sizes} option is {@code false}. The sum of
     *         the elements of {@code fullSizes}.
     * 
     */
    public long getTotalFullSize() {
        return totalFullSize;
    }

    /**
     * 
     * @param totalFullSize  -1 if the {@code get_sizes} option is {@code
     *                       false}. The sum of the elements of {@code
     *                       fullSizes}.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public ShowTableResponse setTotalFullSize(long totalFullSize) {
        this.totalFullSize = totalFullSize;
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
                return this.tableNames;

            case 2:
                return this.tableDescriptions;

            case 3:
                return this.typeIds;

            case 4:
                return this.typeSchemas;

            case 5:
                return this.typeLabels;

            case 6:
                return this.properties;

            case 7:
                return this.additionalInfo;

            case 8:
                return this.sizes;

            case 9:
                return this.fullSizes;

            case 10:
                return this.joinSizes;

            case 11:
                return this.totalSize;

            case 12:
                return this.totalFullSize;

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
                this.tableNames = (List<String>)value;
                break;

            case 2:
                this.tableDescriptions = (List<List<String>>)value;
                break;

            case 3:
                this.typeIds = (List<String>)value;
                break;

            case 4:
                this.typeSchemas = (List<String>)value;
                break;

            case 5:
                this.typeLabels = (List<String>)value;
                break;

            case 6:
                this.properties = (List<Map<String, List<String>>>)value;
                break;

            case 7:
                this.additionalInfo = (List<Map<String, String>>)value;
                break;

            case 8:
                this.sizes = (List<Long>)value;
                break;

            case 9:
                this.fullSizes = (List<Long>)value;
                break;

            case 10:
                this.joinSizes = (List<Double>)value;
                break;

            case 11:
                this.totalSize = (Long)value;
                break;

            case 12:
                this.totalFullSize = (Long)value;
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

        ShowTableResponse that = (ShowTableResponse)obj;

        return ( this.tableName.equals( that.tableName )
                 && this.tableNames.equals( that.tableNames )
                 && this.tableDescriptions.equals( that.tableDescriptions )
                 && this.typeIds.equals( that.typeIds )
                 && this.typeSchemas.equals( that.typeSchemas )
                 && this.typeLabels.equals( that.typeLabels )
                 && this.properties.equals( that.properties )
                 && this.additionalInfo.equals( that.additionalInfo )
                 && this.sizes.equals( that.sizes )
                 && this.fullSizes.equals( that.fullSizes )
                 && this.joinSizes.equals( that.joinSizes )
                 && ( this.totalSize == that.totalSize )
                 && ( this.totalFullSize == that.totalFullSize ) );
    }

    @Override
    public String toString() {
        GenericData gd = GenericData.get();
        StringBuilder builder = new StringBuilder();
        builder.append( "{" );
        builder.append( gd.toString( "tableName" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.tableName ) );
        builder.append( ", " );
        builder.append( gd.toString( "tableNames" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.tableNames ) );
        builder.append( ", " );
        builder.append( gd.toString( "tableDescriptions" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.tableDescriptions ) );
        builder.append( ", " );
        builder.append( gd.toString( "typeIds" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.typeIds ) );
        builder.append( ", " );
        builder.append( gd.toString( "typeSchemas" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.typeSchemas ) );
        builder.append( ", " );
        builder.append( gd.toString( "typeLabels" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.typeLabels ) );
        builder.append( ", " );
        builder.append( gd.toString( "properties" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.properties ) );
        builder.append( ", " );
        builder.append( gd.toString( "additionalInfo" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.additionalInfo ) );
        builder.append( ", " );
        builder.append( gd.toString( "sizes" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.sizes ) );
        builder.append( ", " );
        builder.append( gd.toString( "fullSizes" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.fullSizes ) );
        builder.append( ", " );
        builder.append( gd.toString( "joinSizes" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.joinSizes ) );
        builder.append( ", " );
        builder.append( gd.toString( "totalSize" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.totalSize ) );
        builder.append( ", " );
        builder.append( gd.toString( "totalFullSize" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.totalFullSize ) );
        builder.append( "}" );

        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = (31 * hashCode) + this.tableName.hashCode();
        hashCode = (31 * hashCode) + this.tableNames.hashCode();
        hashCode = (31 * hashCode) + this.tableDescriptions.hashCode();
        hashCode = (31 * hashCode) + this.typeIds.hashCode();
        hashCode = (31 * hashCode) + this.typeSchemas.hashCode();
        hashCode = (31 * hashCode) + this.typeLabels.hashCode();
        hashCode = (31 * hashCode) + this.properties.hashCode();
        hashCode = (31 * hashCode) + this.additionalInfo.hashCode();
        hashCode = (31 * hashCode) + this.sizes.hashCode();
        hashCode = (31 * hashCode) + this.fullSizes.hashCode();
        hashCode = (31 * hashCode) + this.joinSizes.hashCode();
        hashCode = (31 * hashCode) + ((Long)this.totalSize).hashCode();
        hashCode = (31 * hashCode) + ((Long)this.totalFullSize).hashCode();
        return hashCode;
    }

}
