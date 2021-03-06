/*
 *  This file was autogenerated by the GPUdb schema processor.
 *
 *  DO NOT EDIT DIRECTLY.
 */
package com.gpudb.protocol;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.IndexedRecord;


/**
 * A set of parameters for {@link com.gpudb.GPUdb#lockTable(LockTableRequest)}.
 * <p>
 * Manages global access to a table's data.  By default a table has a {@code
 * lockType} of {@code unlock}, indicating all operations are permitted.  A
 * user may request a {@code read-only} or a {@code write-only} lock, after
 * which only read or write operations, respectively, are permitted on the
 * table until the lock is removed.  When {@code lockType} is {@code disable}
 * then no operations are permitted on the table.  The lock status can be
 * queried by setting {@code lockType} to {@code status}.
 */
public class LockTableRequest implements IndexedRecord {
    private static final Schema schema$ = SchemaBuilder
            .record("LockTableRequest")
            .namespace("com.gpudb")
            .fields()
                .name("tableName").type().stringType().noDefault()
                .name("lockType").type().stringType().noDefault()
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
     * The type of lock being applied to the table. Setting it to {@code
     * status} will return the current lock status of the table without
     * changing it. Values: status, disable, read-only, write-only, unlock.

     * A set of string constants for the parameter {@code lockType}.
     */
    public static final class LockType {

        /**
         * Show locked status
         */
        public static final String STATUS = "status";

        /**
         * Allow no read/write operations
         */
        public static final String DISABLE = "disable";

        /**
         * Allow only read operations
         */
        public static final String READ_ONLY = "read-only";

        /**
         * Allow only write operations
         */
        public static final String WRITE_ONLY = "write-only";

        /**
         * Allow all read/write operations
         */
        public static final String UNLOCK = "unlock";

        private LockType() {  }
    }

    private String tableName;
    private String lockType;
    private Map<String, String> options;


    /**
     * Constructs a LockTableRequest object with default parameters.
     */
    public LockTableRequest() {
        tableName = "";
        lockType = "";
        options = new LinkedHashMap<>();
    }

    /**
     * Constructs a LockTableRequest object with the specified parameters.
     * 
     * @param tableName  Name of the table to be locked. It must be a currently
     *                   existing table, collection, or view.
     * @param lockType  The type of lock being applied to the table. Setting it
     *                  to {@code status} will return the current lock status
     *                  of the table without changing it. Values: status,
     *                  disable, read-only, write-only, unlock.
     * @param options  Optional parameters.
     * 
     */
    public LockTableRequest(String tableName, String lockType, Map<String, String> options) {
        this.tableName = (tableName == null) ? "" : tableName;
        this.lockType = (lockType == null) ? "" : lockType;
        this.options = (options == null) ? new LinkedHashMap<String, String>() : options;
    }

    /**
     * 
     * @return Name of the table to be locked. It must be a currently existing
     *         table, collection, or view.
     * 
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName  Name of the table to be locked. It must be a currently
     *                   existing table, collection, or view.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public LockTableRequest setTableName(String tableName) {
        this.tableName = (tableName == null) ? "" : tableName;
        return this;
    }

    /**
     * 
     * @return The type of lock being applied to the table. Setting it to
     *         {@code status} will return the current lock status of the table
     *         without changing it. Values: status, disable, read-only,
     *         write-only, unlock.
     * 
     */
    public String getLockType() {
        return lockType;
    }

    /**
     * 
     * @param lockType  The type of lock being applied to the table. Setting it
     *                  to {@code status} will return the current lock status
     *                  of the table without changing it. Values: status,
     *                  disable, read-only, write-only, unlock.
     * 
     * @return {@code this} to mimic the builder pattern.
     * 
     */
    public LockTableRequest setLockType(String lockType) {
        this.lockType = (lockType == null) ? "" : lockType;
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
    public LockTableRequest setOptions(Map<String, String> options) {
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
                return this.lockType;

            case 2:
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
                this.lockType = (String)value;
                break;

            case 2:
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

        LockTableRequest that = (LockTableRequest)obj;

        return ( this.tableName.equals( that.tableName )
                 && this.lockType.equals( that.lockType )
                 && this.options.equals( that.options ) );
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
        builder.append( gd.toString( "lockType" ) );
        builder.append( ": " );
        builder.append( gd.toString( this.lockType ) );
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
        hashCode = (31 * hashCode) + this.tableName.hashCode();
        hashCode = (31 * hashCode) + this.lockType.hashCode();
        hashCode = (31 * hashCode) + this.options.hashCode();
        return hashCode;
    }

}
