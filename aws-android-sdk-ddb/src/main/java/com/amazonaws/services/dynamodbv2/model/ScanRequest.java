/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * Container for the parameters to the {@link com.amazonaws.services.dynamodbv2.AmazonDynamoDB#scan(ScanRequest) Scan operation}.
 * <p>
 * The <i>Scan</i> operation returns one or more items and item
 * attributes by accessing every item in a table or a secondary index. To
 * have DynamoDB return fewer items, you can provide a <i>ScanFilter</i>
 * operation.
 * </p>
 * <p>
 * If the total number of scanned items exceeds the maximum data set size
 * limit of 1 MB, the scan stops and results are returned to the user as
 * a <i>LastEvaluatedKey</i> value to continue the scan in a subsequent
 * operation. The results also include the number of items exceeding the
 * limit. A scan can result in no table data meeting the filter criteria.
 * </p>
 * <p>
 * By default, <i>Scan</i> operations proceed sequentially; however, for
 * faster performance on a large table or secondary index, applications
 * can request a parallel <i>Scan</i> operation by providing the
 * <i>Segment</i> and <i>TotalSegments</i> parameters. For more
 * information, see
 * <a href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#QueryAndScanParallelScan"> Parallel Scan </a>
 * in the <i>Amazon DynamoDB Developer Guide</i> .
 * </p>
 * <p>
 * By default, <i>Scan</i> uses eventually consistent reads when
 * accessing the data in a table; therefore, the result set might not
 * include the changes to data in the table immediately before the
 * operation began. If you need a consistent copy of the data, as of the
 * time that the Scan begins, you can set the <i>ConsistentRead</i>
 * parameter to <i>true</i> .
 * </p>
 *
 * @see com.amazonaws.services.dynamodbv2.AmazonDynamoDB#scan(ScanRequest)
 */
public class ScanRequest extends AmazonWebServiceRequest implements Serializable {

    /**
     * The name of the table containing the requested items; or, if you
     * provide <code>IndexName</code>, the name of the table to which that
     * index belongs.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     */
    private String tableName;

    /**
     * The name of a secondary index to scan. This index can be any local
     * secondary index or global secondary index. Note that if you use the
     * <code>IndexName</code> parameter, you must also provide
     * <code>TableName</code>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     */
    private String indexName;

    /**
     * <important><p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>ProjectionExpression</i> instead. Do
     * not combine legacy parameters and expression parameters in a single
     * API call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. <p>This parameter allows you to retrieve attributes of type
     * List or Map; however, it cannot retrieve individual elements within a
     * List or a Map.</important> <p>The names of one or more attributes to
     * retrieve. If no attribute names are provided, then all attributes will
     * be returned. If any of the requested attributes are not found, they
     * will not appear in the result. <p>Note that <i>AttributesToGet</i> has
     * no effect on provisioned throughput consumption. DynamoDB determines
     * capacity units consumed based on item size, not on the amount of data
     * that is returned to an application.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - <br/>
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<String> attributesToGet;

    /**
     * The maximum number of items to evaluate (not necessarily the number of
     * matching items). If DynamoDB processes the number of items up to the
     * limit while processing the results, it stops the operation and returns
     * the matching values up to that point, and a key in
     * <i>LastEvaluatedKey</i> to apply in a subsequent operation, so that
     * you can pick up where you left off. Also, if the processed data set
     * size exceeds 1 MB before DynamoDB reaches this limit, it stops the
     * operation and returns the matching values up to the limit, and a key
     * in <i>LastEvaluatedKey</i> to apply in a subsequent operation to
     * continue the operation. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query
     * and Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - <br/>
     */
    private Integer limit;

    /**
     * The attributes to be returned in the result. You can retrieve all item
     * attributes, specific item attributes, or the count of matching items.
     * <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     * attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     * matching items, rather than the matching items themselves. </li> <li>
     * <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     * listed in <i>AttributesToGet</i>. This return value is equivalent to
     * specifying <i>AttributesToGet</i> without specifying any value for
     * <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     * <i>AttributesToGet</i> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code>. You cannot use both
     * <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     * unless the value for <i>Select</i> is
     * <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <i>AttributesToGet</i> without any value for
     * <i>Select</i>.)
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>ALL_ATTRIBUTES, ALL_PROJECTED_ATTRIBUTES, SPECIFIC_ATTRIBUTES, COUNT
     */
    private String select;

    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A condition that evaluates the scan results
     * and returns only the desired values. <note><p>This parameter does not
     * support attributes of type List or Map.</note> <p>If you specify more
     * than one condition in the <i>ScanFilter</i> map, then by default all
     * of the conditions must evaluate to true. In other words, the
     * conditions are ANDed together. (You can use the
     * <i>ConditionalOperator</i> parameter to OR the conditions instead. If
     * you do this, then at least one of the conditions must evaluate to
     * true, rather than all of them.) <p>Each <i>ScanFilter</i> element
     * consists of an attribute name to compare, along with the following:
     * <ul> <li> <p><i>AttributeValueList</i> - One or more values to
     * evaluate against the supplied attribute. The number of values in the
     * list depends on the operator specified in <i>ComparisonOperator</i> .
     * <p>For type Number, value comparisons are numeric. <p>String value
     * comparisons for greater than, equals, or less than are based on ASCII
     * character code values. For example, <code>a</code> is greater than
     * <code>A</code>, and <code>a</code> is greater than <code>B</code>. For
     * a list of code values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     * <p>For Binary, DynamoDB treats each byte of the binary data as
     * unsigned when it compares binary values. <p>For information on
     * specifying data types in JSON, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON
     * Data Format</a> in the <i>Amazon DynamoDB Developer Guide</i>. </li>
     * <li><p><i>ComparisonOperator</i> - A comparator for evaluating
     * attributes. For example, equals, greater than, less than, etc. <p>The
     * following comparison operators are available: <p><code>EQ | NE | LE |
     * LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH
     * | IN | BETWEEN</code> <p>For complete descriptions of all comparison
     * operators, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Condition.html">Condition</a>.
     * </li> </ul>
     */
    private java.util.Map<String,Condition> scanFilter;

    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A logical operator to apply to the
     * conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     * If all of the conditions evaluate to true, then the entire map
     * evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     * the conditions evaluate to true, then the entire map evaluates to
     * true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     * <code>AND</code> is the default. <p>The operation will succeed only if
     * the entire map evaluates to true. <note><p>This parameter does not
     * support attributes of type List or Map.</note>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>AND, OR
     */
    private String conditionalOperator;

    /**
     * The primary key of the first item that this operation will evaluate.
     * Use the value that was returned for <i>LastEvaluatedKey</i> in the
     * previous operation. <p>The data type for <i>ExclusiveStartKey</i> must
     * be String, Number or Binary. No set data types are allowed. <p>In a
     * parallel scan, a <i>Scan</i> request that includes
     * <i>ExclusiveStartKey</i> must specify the same segment whose previous
     * <i>Scan</i> returned the corresponding value of
     * <i>LastEvaluatedKey</i>.
     */
    private java.util.Map<String,AttributeValue> exclusiveStartKey;

    /**
     * Determines the level of detail about provisioned throughput
     * consumption that is returned in the response: <ul>
     * <li><p><i>INDEXES</i> - The response includes the aggregate
     * <i>ConsumedCapacity</i> for the operation, together with
     * <i>ConsumedCapacity</i> for each table and secondary index that was
     * accessed. <p>Note that some operations, such as <i>GetItem</i> and
     * <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     * specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     * information for table(s).</li> <li><p><i>TOTAL</i> - The response
     * includes only the aggregate <i>ConsumedCapacity</i> for the
     * operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     * details are included in the response.</li> </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INDEXES, TOTAL, NONE
     */
    private String returnConsumedCapacity;

    /**
     * For a parallel <i>Scan</i> request, <i>TotalSegments</i> represents
     * the total number of segments into which the <i>Scan</i> operation will
     * be divided. The value of <i>TotalSegments</i> corresponds to the
     * number of application workers that will perform the parallel scan. For
     * example, if you want to use four application threads to scan a table
     * or an index, specify a <i>TotalSegments</i> value of 4. <p>The value
     * for <i>TotalSegments</i> must be greater than or equal to 1, and less
     * than or equal to 1000000. If you specify a <i>TotalSegments</i> value
     * of 1, the <i>Scan</i> operation will be sequential rather than
     * parallel. <p>If you specify <i>TotalSegments</i>, you must also
     * specify <i>Segment</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - 1000000<br/>
     */
    private Integer totalSegments;

    /**
     * For a parallel <i>Scan</i> request, <i>Segment</i> identifies an
     * individual segment to be scanned by an application worker. <p>Segment
     * IDs are zero-based, so the first segment is always 0. For example, if
     * you want to use four application threads to scan a table or an index,
     * then the first thread specifies a <i>Segment</i> value of 0, the
     * second thread specifies 1, and so on. <p>The value of
     * <i>LastEvaluatedKey</i> returned from a parallel <i>Scan</i> request
     * must be used as <i>ExclusiveStartKey</i> with the same segment ID in a
     * subsequent <i>Scan</i> operation. <p>The value for <i>Segment</i> must
     * be greater than or equal to 0, and less than the value provided for
     * <i>TotalSegments</i>. <p>If you provide <i>Segment</i>, you must also
     * provide <i>TotalSegments</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>0 - 999999<br/>
     */
    private Integer segment;

    /**
     * A string that identifies one or more attributes to retrieve from the
     * specified table or index. These attributes can include scalars, sets,
     * or elements of a JSON document. The attributes in the expression must
     * be separated by commas. <p>If no attribute names are specified, then
     * all attributes will be returned. If any of the requested attributes
     * are not found, they will not appear in the result. <p>For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     * Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <note><p><i>ProjectionExpression</i> replaces the legacy
     * <i>AttributesToGet</i> parameter.</note>
     */
    private String projectionExpression;

    /**
     * A string that contains conditions that DynamoDB applies after the
     * <i>Scan</i> operation, but before the data is returned to you. Items
     * that do not satisfy the <i>FilterExpression</i> criteria are not
     * returned. <note> <p>A <i>FilterExpression</i> is applied after the
     * items have already been read; the process of filtering does not
     * consume any additional read capacity units.</note> <p>For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     * Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <note><p><i>FilterExpression</i> replaces the legacy <i>ScanFilter</i>
     * and <i>ConditionalOperator</i> parameters.</note>
     */
    private String filterExpression;

    /**
     * One or more substitution tokens for attribute names in an expression.
     * The following are some use cases for using
     * <i>ExpressionAttributeNames</i>: <ul> <li> <p>To access an attribute
     * whose name conflicts with a DynamoDB reserved word. </li> <li> <p>To
     * create a placeholder for repeating occurrences of an attribute name in
     * an expression. </li> <li> <p>To prevent special characters in an
     * attribute name from being misinterpreted in an expression. </li> </ul>
     * <p>Use the <b>#</b> character in an expression to dereference an
     * attribute name. For example, consider the following attribute name:
     * <ul><li><p><code>Percentile</code></li></ul> <p>The name of this
     * attribute conflicts with a reserved word, so it cannot be used
     * directly in an expression. (For the complete list of reserved words,
     * see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     * Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work
     * around this, you could specify the following for
     * <i>ExpressionAttributeNames</i>:
     * <ul><li><p><code>{"#P":"Percentile"}</code></li></ul> <p>You could
     * then use this substitution in an expression, as in this example:
     * <ul><li><p><code>#P = :val</code></li></ul> <note><p>Tokens that begin
     * with the <b>:</b> character are <i>expression attribute values</i>,
     * which are placeholders for the actual value at runtime.</note> <p>For
     * more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     * Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    private java.util.Map<String,String> expressionAttributeNames;

    /**
     * One or more values that can be substituted in an expression. <p>Use
     * the <b>:</b> (colon) character in an expression to dereference an
     * attribute value. For example, suppose that you wanted to check whether
     * the value of the <i>ProductStatus</i> attribute was one of the
     * following: <p><code>Available | Backordered | Discontinued</code>
     * <p>You would first need to specify <i>ExpressionAttributeValues</i> as
     * follows: <p><code>{ ":avail":{"S":"Available"},
     * ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     * <p>You could then use these values in an expression, such as this:
     * <p><code>ProductStatus IN (:avail, :back, :disc)</code> <p>For more
     * information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html">Specifying
     * Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    private java.util.Map<String,AttributeValue> expressionAttributeValues;

    /**
     * A Boolean value that determines the read consistency model during the
     * scan: <ul> <li> <p>If <i>ConsistentRead</i> is <code>false</code>,
     * then the data returned from <i>Scan</i> might not contain the results
     * from other recently completed write operations (PutItem, UpdateItem or
     * DeleteItem). </li> <li> <p>If <i>ConsistentRead</i> is
     * <code>true</code>, then all of the write operations that completed
     * before the <i>Scan</i> began are guaranteed to be contained in the
     * <i>Scan</i> response. </li> </ul> <p>The default setting for
     * <i>ConsistentRead</i> is <code>false</code>. <p>The
     * <i>ConsistentRead</i> parameter is not supported on global secondary
     * indexes. If you scan a global secondary index with
     * <i>ConsistentRead</i> set to true, you will receive a
     * <i>ValidationException</i>.
     */
    private Boolean consistentRead;

    /**
     * Default constructor for a new ScanRequest object.  Callers should use the
     * setter or fluent setter (with...) methods to initialize this object after creating it.
     */
    public ScanRequest() {}
    
    /**
     * Constructs a new ScanRequest object.
     * Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName The name of the table containing the requested items;
     * or, if you provide <code>IndexName</code>, the name of the table to
     * which that index belongs.
     */
    public ScanRequest(String tableName) {
        setTableName(tableName);
    }

    /**
     * The name of the table containing the requested items; or, if you
     * provide <code>IndexName</code>, the name of the table to which that
     * index belongs.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     *
     * @return The name of the table containing the requested items; or, if you
     *         provide <code>IndexName</code>, the name of the table to which that
     *         index belongs.
     */
    public String getTableName() {
        return tableName;
    }
    
    /**
     * The name of the table containing the requested items; or, if you
     * provide <code>IndexName</code>, the name of the table to which that
     * index belongs.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     *
     * @param tableName The name of the table containing the requested items; or, if you
     *         provide <code>IndexName</code>, the name of the table to which that
     *         index belongs.
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    /**
     * The name of the table containing the requested items; or, if you
     * provide <code>IndexName</code>, the name of the table to which that
     * index belongs.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     *
     * @param tableName The name of the table containing the requested items; or, if you
     *         provide <code>IndexName</code>, the name of the table to which that
     *         index belongs.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    /**
     * The name of a secondary index to scan. This index can be any local
     * secondary index or global secondary index. Note that if you use the
     * <code>IndexName</code> parameter, you must also provide
     * <code>TableName</code>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     *
     * @return The name of a secondary index to scan. This index can be any local
     *         secondary index or global secondary index. Note that if you use the
     *         <code>IndexName</code> parameter, you must also provide
     *         <code>TableName</code>.
     */
    public String getIndexName() {
        return indexName;
    }
    
    /**
     * The name of a secondary index to scan. This index can be any local
     * secondary index or global secondary index. Note that if you use the
     * <code>IndexName</code> parameter, you must also provide
     * <code>TableName</code>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     *
     * @param indexName The name of a secondary index to scan. This index can be any local
     *         secondary index or global secondary index. Note that if you use the
     *         <code>IndexName</code> parameter, you must also provide
     *         <code>TableName</code>.
     */
    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
    
    /**
     * The name of a secondary index to scan. This index can be any local
     * secondary index or global secondary index. Note that if you use the
     * <code>IndexName</code> parameter, you must also provide
     * <code>TableName</code>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     *
     * @param indexName The name of a secondary index to scan. This index can be any local
     *         secondary index or global secondary index. Note that if you use the
     *         <code>IndexName</code> parameter, you must also provide
     *         <code>TableName</code>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withIndexName(String indexName) {
        this.indexName = indexName;
        return this;
    }

    /**
     * <important><p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>ProjectionExpression</i> instead. Do
     * not combine legacy parameters and expression parameters in a single
     * API call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. <p>This parameter allows you to retrieve attributes of type
     * List or Map; however, it cannot retrieve individual elements within a
     * List or a Map.</important> <p>The names of one or more attributes to
     * retrieve. If no attribute names are provided, then all attributes will
     * be returned. If any of the requested attributes are not found, they
     * will not appear in the result. <p>Note that <i>AttributesToGet</i> has
     * no effect on provisioned throughput consumption. DynamoDB determines
     * capacity units consumed based on item size, not on the amount of data
     * that is returned to an application.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - <br/>
     *
     * @return <important><p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>ProjectionExpression</i> instead. Do
     *         not combine legacy parameters and expression parameters in a single
     *         API call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. <p>This parameter allows you to retrieve attributes of type
     *         List or Map; however, it cannot retrieve individual elements within a
     *         List or a Map.</important> <p>The names of one or more attributes to
     *         retrieve. If no attribute names are provided, then all attributes will
     *         be returned. If any of the requested attributes are not found, they
     *         will not appear in the result. <p>Note that <i>AttributesToGet</i> has
     *         no effect on provisioned throughput consumption. DynamoDB determines
     *         capacity units consumed based on item size, not on the amount of data
     *         that is returned to an application.
     */
    public java.util.List<String> getAttributesToGet() {
        return attributesToGet;
    }
    
    /**
     * <important><p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>ProjectionExpression</i> instead. Do
     * not combine legacy parameters and expression parameters in a single
     * API call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. <p>This parameter allows you to retrieve attributes of type
     * List or Map; however, it cannot retrieve individual elements within a
     * List or a Map.</important> <p>The names of one or more attributes to
     * retrieve. If no attribute names are provided, then all attributes will
     * be returned. If any of the requested attributes are not found, they
     * will not appear in the result. <p>Note that <i>AttributesToGet</i> has
     * no effect on provisioned throughput consumption. DynamoDB determines
     * capacity units consumed based on item size, not on the amount of data
     * that is returned to an application.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - <br/>
     *
     * @param attributesToGet <important><p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>ProjectionExpression</i> instead. Do
     *         not combine legacy parameters and expression parameters in a single
     *         API call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. <p>This parameter allows you to retrieve attributes of type
     *         List or Map; however, it cannot retrieve individual elements within a
     *         List or a Map.</important> <p>The names of one or more attributes to
     *         retrieve. If no attribute names are provided, then all attributes will
     *         be returned. If any of the requested attributes are not found, they
     *         will not appear in the result. <p>Note that <i>AttributesToGet</i> has
     *         no effect on provisioned throughput consumption. DynamoDB determines
     *         capacity units consumed based on item size, not on the amount of data
     *         that is returned to an application.
     */
    public void setAttributesToGet(java.util.Collection<String> attributesToGet) {
        if (attributesToGet == null) {
            this.attributesToGet = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<String> attributesToGetCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(attributesToGet.size());
        attributesToGetCopy.addAll(attributesToGet);
        this.attributesToGet = attributesToGetCopy;
    }
    
    /**
     * <important><p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>ProjectionExpression</i> instead. Do
     * not combine legacy parameters and expression parameters in a single
     * API call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. <p>This parameter allows you to retrieve attributes of type
     * List or Map; however, it cannot retrieve individual elements within a
     * List or a Map.</important> <p>The names of one or more attributes to
     * retrieve. If no attribute names are provided, then all attributes will
     * be returned. If any of the requested attributes are not found, they
     * will not appear in the result. <p>Note that <i>AttributesToGet</i> has
     * no effect on provisioned throughput consumption. DynamoDB determines
     * capacity units consumed based on item size, not on the amount of data
     * that is returned to an application.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - <br/>
     *
     * @param attributesToGet <important><p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>ProjectionExpression</i> instead. Do
     *         not combine legacy parameters and expression parameters in a single
     *         API call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. <p>This parameter allows you to retrieve attributes of type
     *         List or Map; however, it cannot retrieve individual elements within a
     *         List or a Map.</important> <p>The names of one or more attributes to
     *         retrieve. If no attribute names are provided, then all attributes will
     *         be returned. If any of the requested attributes are not found, they
     *         will not appear in the result. <p>Note that <i>AttributesToGet</i> has
     *         no effect on provisioned throughput consumption. DynamoDB determines
     *         capacity units consumed based on item size, not on the amount of data
     *         that is returned to an application.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withAttributesToGet(String... attributesToGet) {
        if (getAttributesToGet() == null) setAttributesToGet(new java.util.ArrayList<String>(attributesToGet.length));
        for (String value : attributesToGet) {
            getAttributesToGet().add(value);
        }
        return this;
    }
    
    /**
     * <important><p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>ProjectionExpression</i> instead. Do
     * not combine legacy parameters and expression parameters in a single
     * API call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. <p>This parameter allows you to retrieve attributes of type
     * List or Map; however, it cannot retrieve individual elements within a
     * List or a Map.</important> <p>The names of one or more attributes to
     * retrieve. If no attribute names are provided, then all attributes will
     * be returned. If any of the requested attributes are not found, they
     * will not appear in the result. <p>Note that <i>AttributesToGet</i> has
     * no effect on provisioned throughput consumption. DynamoDB determines
     * capacity units consumed based on item size, not on the amount of data
     * that is returned to an application.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - <br/>
     *
     * @param attributesToGet <important><p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>ProjectionExpression</i> instead. Do
     *         not combine legacy parameters and expression parameters in a single
     *         API call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. <p>This parameter allows you to retrieve attributes of type
     *         List or Map; however, it cannot retrieve individual elements within a
     *         List or a Map.</important> <p>The names of one or more attributes to
     *         retrieve. If no attribute names are provided, then all attributes will
     *         be returned. If any of the requested attributes are not found, they
     *         will not appear in the result. <p>Note that <i>AttributesToGet</i> has
     *         no effect on provisioned throughput consumption. DynamoDB determines
     *         capacity units consumed based on item size, not on the amount of data
     *         that is returned to an application.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withAttributesToGet(java.util.Collection<String> attributesToGet) {
        if (attributesToGet == null) {
            this.attributesToGet = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<String> attributesToGetCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(attributesToGet.size());
            attributesToGetCopy.addAll(attributesToGet);
            this.attributesToGet = attributesToGetCopy;
        }

        return this;
    }

    /**
     * The maximum number of items to evaluate (not necessarily the number of
     * matching items). If DynamoDB processes the number of items up to the
     * limit while processing the results, it stops the operation and returns
     * the matching values up to that point, and a key in
     * <i>LastEvaluatedKey</i> to apply in a subsequent operation, so that
     * you can pick up where you left off. Also, if the processed data set
     * size exceeds 1 MB before DynamoDB reaches this limit, it stops the
     * operation and returns the matching values up to the limit, and a key
     * in <i>LastEvaluatedKey</i> to apply in a subsequent operation to
     * continue the operation. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query
     * and Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - <br/>
     *
     * @return The maximum number of items to evaluate (not necessarily the number of
     *         matching items). If DynamoDB processes the number of items up to the
     *         limit while processing the results, it stops the operation and returns
     *         the matching values up to that point, and a key in
     *         <i>LastEvaluatedKey</i> to apply in a subsequent operation, so that
     *         you can pick up where you left off. Also, if the processed data set
     *         size exceeds 1 MB before DynamoDB reaches this limit, it stops the
     *         operation and returns the matching values up to the limit, and a key
     *         in <i>LastEvaluatedKey</i> to apply in a subsequent operation to
     *         continue the operation. For more information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query
     *         and Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    public Integer getLimit() {
        return limit;
    }
    
    /**
     * The maximum number of items to evaluate (not necessarily the number of
     * matching items). If DynamoDB processes the number of items up to the
     * limit while processing the results, it stops the operation and returns
     * the matching values up to that point, and a key in
     * <i>LastEvaluatedKey</i> to apply in a subsequent operation, so that
     * you can pick up where you left off. Also, if the processed data set
     * size exceeds 1 MB before DynamoDB reaches this limit, it stops the
     * operation and returns the matching values up to the limit, and a key
     * in <i>LastEvaluatedKey</i> to apply in a subsequent operation to
     * continue the operation. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query
     * and Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - <br/>
     *
     * @param limit The maximum number of items to evaluate (not necessarily the number of
     *         matching items). If DynamoDB processes the number of items up to the
     *         limit while processing the results, it stops the operation and returns
     *         the matching values up to that point, and a key in
     *         <i>LastEvaluatedKey</i> to apply in a subsequent operation, so that
     *         you can pick up where you left off. Also, if the processed data set
     *         size exceeds 1 MB before DynamoDB reaches this limit, it stops the
     *         operation and returns the matching values up to the limit, and a key
     *         in <i>LastEvaluatedKey</i> to apply in a subsequent operation to
     *         continue the operation. For more information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query
     *         and Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    /**
     * The maximum number of items to evaluate (not necessarily the number of
     * matching items). If DynamoDB processes the number of items up to the
     * limit while processing the results, it stops the operation and returns
     * the matching values up to that point, and a key in
     * <i>LastEvaluatedKey</i> to apply in a subsequent operation, so that
     * you can pick up where you left off. Also, if the processed data set
     * size exceeds 1 MB before DynamoDB reaches this limit, it stops the
     * operation and returns the matching values up to the limit, and a key
     * in <i>LastEvaluatedKey</i> to apply in a subsequent operation to
     * continue the operation. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query
     * and Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - <br/>
     *
     * @param limit The maximum number of items to evaluate (not necessarily the number of
     *         matching items). If DynamoDB processes the number of items up to the
     *         limit while processing the results, it stops the operation and returns
     *         the matching values up to that point, and a key in
     *         <i>LastEvaluatedKey</i> to apply in a subsequent operation, so that
     *         you can pick up where you left off. Also, if the processed data set
     *         size exceeds 1 MB before DynamoDB reaches this limit, it stops the
     *         operation and returns the matching values up to the limit, and a key
     *         in <i>LastEvaluatedKey</i> to apply in a subsequent operation to
     *         continue the operation. For more information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query
     *         and Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * The attributes to be returned in the result. You can retrieve all item
     * attributes, specific item attributes, or the count of matching items.
     * <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     * attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     * matching items, rather than the matching items themselves. </li> <li>
     * <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     * listed in <i>AttributesToGet</i>. This return value is equivalent to
     * specifying <i>AttributesToGet</i> without specifying any value for
     * <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     * <i>AttributesToGet</i> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code>. You cannot use both
     * <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     * unless the value for <i>Select</i> is
     * <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <i>AttributesToGet</i> without any value for
     * <i>Select</i>.)
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>ALL_ATTRIBUTES, ALL_PROJECTED_ATTRIBUTES, SPECIFIC_ATTRIBUTES, COUNT
     *
     * @return The attributes to be returned in the result. You can retrieve all item
     *         attributes, specific item attributes, or the count of matching items.
     *         <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     *         attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     *         matching items, rather than the matching items themselves. </li> <li>
     *         <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     *         listed in <i>AttributesToGet</i>. This return value is equivalent to
     *         specifying <i>AttributesToGet</i> without specifying any value for
     *         <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     *         <i>AttributesToGet</i> are specified, DynamoDB defaults to
     *         <code>ALL_ATTRIBUTES</code>. You cannot use both
     *         <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     *         unless the value for <i>Select</i> is
     *         <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     *         specifying <i>AttributesToGet</i> without any value for
     *         <i>Select</i>.)
     *
     * @see Select
     */
    public String getSelect() {
        return select;
    }
    
    /**
     * The attributes to be returned in the result. You can retrieve all item
     * attributes, specific item attributes, or the count of matching items.
     * <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     * attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     * matching items, rather than the matching items themselves. </li> <li>
     * <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     * listed in <i>AttributesToGet</i>. This return value is equivalent to
     * specifying <i>AttributesToGet</i> without specifying any value for
     * <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     * <i>AttributesToGet</i> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code>. You cannot use both
     * <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     * unless the value for <i>Select</i> is
     * <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <i>AttributesToGet</i> without any value for
     * <i>Select</i>.)
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>ALL_ATTRIBUTES, ALL_PROJECTED_ATTRIBUTES, SPECIFIC_ATTRIBUTES, COUNT
     *
     * @param select The attributes to be returned in the result. You can retrieve all item
     *         attributes, specific item attributes, or the count of matching items.
     *         <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     *         attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     *         matching items, rather than the matching items themselves. </li> <li>
     *         <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     *         listed in <i>AttributesToGet</i>. This return value is equivalent to
     *         specifying <i>AttributesToGet</i> without specifying any value for
     *         <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     *         <i>AttributesToGet</i> are specified, DynamoDB defaults to
     *         <code>ALL_ATTRIBUTES</code>. You cannot use both
     *         <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     *         unless the value for <i>Select</i> is
     *         <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     *         specifying <i>AttributesToGet</i> without any value for
     *         <i>Select</i>.)
     *
     * @see Select
     */
    public void setSelect(String select) {
        this.select = select;
    }
    
    /**
     * The attributes to be returned in the result. You can retrieve all item
     * attributes, specific item attributes, or the count of matching items.
     * <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     * attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     * matching items, rather than the matching items themselves. </li> <li>
     * <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     * listed in <i>AttributesToGet</i>. This return value is equivalent to
     * specifying <i>AttributesToGet</i> without specifying any value for
     * <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     * <i>AttributesToGet</i> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code>. You cannot use both
     * <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     * unless the value for <i>Select</i> is
     * <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <i>AttributesToGet</i> without any value for
     * <i>Select</i>.)
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>ALL_ATTRIBUTES, ALL_PROJECTED_ATTRIBUTES, SPECIFIC_ATTRIBUTES, COUNT
     *
     * @param select The attributes to be returned in the result. You can retrieve all item
     *         attributes, specific item attributes, or the count of matching items.
     *         <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     *         attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     *         matching items, rather than the matching items themselves. </li> <li>
     *         <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     *         listed in <i>AttributesToGet</i>. This return value is equivalent to
     *         specifying <i>AttributesToGet</i> without specifying any value for
     *         <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     *         <i>AttributesToGet</i> are specified, DynamoDB defaults to
     *         <code>ALL_ATTRIBUTES</code>. You cannot use both
     *         <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     *         unless the value for <i>Select</i> is
     *         <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     *         specifying <i>AttributesToGet</i> without any value for
     *         <i>Select</i>.)
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see Select
     */
    public ScanRequest withSelect(String select) {
        this.select = select;
        return this;
    }

    /**
     * The attributes to be returned in the result. You can retrieve all item
     * attributes, specific item attributes, or the count of matching items.
     * <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     * attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     * matching items, rather than the matching items themselves. </li> <li>
     * <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     * listed in <i>AttributesToGet</i>. This return value is equivalent to
     * specifying <i>AttributesToGet</i> without specifying any value for
     * <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     * <i>AttributesToGet</i> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code>. You cannot use both
     * <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     * unless the value for <i>Select</i> is
     * <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <i>AttributesToGet</i> without any value for
     * <i>Select</i>.)
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>ALL_ATTRIBUTES, ALL_PROJECTED_ATTRIBUTES, SPECIFIC_ATTRIBUTES, COUNT
     *
     * @param select The attributes to be returned in the result. You can retrieve all item
     *         attributes, specific item attributes, or the count of matching items.
     *         <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     *         attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     *         matching items, rather than the matching items themselves. </li> <li>
     *         <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     *         listed in <i>AttributesToGet</i>. This return value is equivalent to
     *         specifying <i>AttributesToGet</i> without specifying any value for
     *         <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     *         <i>AttributesToGet</i> are specified, DynamoDB defaults to
     *         <code>ALL_ATTRIBUTES</code>. You cannot use both
     *         <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     *         unless the value for <i>Select</i> is
     *         <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     *         specifying <i>AttributesToGet</i> without any value for
     *         <i>Select</i>.)
     *
     * @see Select
     */
    public void setSelect(Select select) {
        this.select = select.toString();
    }
    
    /**
     * The attributes to be returned in the result. You can retrieve all item
     * attributes, specific item attributes, or the count of matching items.
     * <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     * attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     * matching items, rather than the matching items themselves. </li> <li>
     * <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     * listed in <i>AttributesToGet</i>. This return value is equivalent to
     * specifying <i>AttributesToGet</i> without specifying any value for
     * <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     * <i>AttributesToGet</i> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code>. You cannot use both
     * <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     * unless the value for <i>Select</i> is
     * <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <i>AttributesToGet</i> without any value for
     * <i>Select</i>.)
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>ALL_ATTRIBUTES, ALL_PROJECTED_ATTRIBUTES, SPECIFIC_ATTRIBUTES, COUNT
     *
     * @param select The attributes to be returned in the result. You can retrieve all item
     *         attributes, specific item attributes, or the count of matching items.
     *         <ul> <li> <p><code>ALL_ATTRIBUTES</code> - Returns all of the item
     *         attributes. </li> <li> <p><code>COUNT</code> - Returns the number of
     *         matching items, rather than the matching items themselves. </li> <li>
     *         <p> <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes
     *         listed in <i>AttributesToGet</i>. This return value is equivalent to
     *         specifying <i>AttributesToGet</i> without specifying any value for
     *         <i>Select</i>. </li> </ul> <p>If neither <i>Select</i> nor
     *         <i>AttributesToGet</i> are specified, DynamoDB defaults to
     *         <code>ALL_ATTRIBUTES</code>. You cannot use both
     *         <i>AttributesToGet</i> and <i>Select</i> together in a single request,
     *         unless the value for <i>Select</i> is
     *         <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     *         specifying <i>AttributesToGet</i> without any value for
     *         <i>Select</i>.)
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see Select
     */
    public ScanRequest withSelect(Select select) {
        this.select = select.toString();
        return this;
    }

    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A condition that evaluates the scan results
     * and returns only the desired values. <note><p>This parameter does not
     * support attributes of type List or Map.</note> <p>If you specify more
     * than one condition in the <i>ScanFilter</i> map, then by default all
     * of the conditions must evaluate to true. In other words, the
     * conditions are ANDed together. (You can use the
     * <i>ConditionalOperator</i> parameter to OR the conditions instead. If
     * you do this, then at least one of the conditions must evaluate to
     * true, rather than all of them.) <p>Each <i>ScanFilter</i> element
     * consists of an attribute name to compare, along with the following:
     * <ul> <li> <p><i>AttributeValueList</i> - One or more values to
     * evaluate against the supplied attribute. The number of values in the
     * list depends on the operator specified in <i>ComparisonOperator</i> .
     * <p>For type Number, value comparisons are numeric. <p>String value
     * comparisons for greater than, equals, or less than are based on ASCII
     * character code values. For example, <code>a</code> is greater than
     * <code>A</code>, and <code>a</code> is greater than <code>B</code>. For
     * a list of code values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     * <p>For Binary, DynamoDB treats each byte of the binary data as
     * unsigned when it compares binary values. <p>For information on
     * specifying data types in JSON, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON
     * Data Format</a> in the <i>Amazon DynamoDB Developer Guide</i>. </li>
     * <li><p><i>ComparisonOperator</i> - A comparator for evaluating
     * attributes. For example, equals, greater than, less than, etc. <p>The
     * following comparison operators are available: <p><code>EQ | NE | LE |
     * LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH
     * | IN | BETWEEN</code> <p>For complete descriptions of all comparison
     * operators, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Condition.html">Condition</a>.
     * </li> </ul>
     *
     * @return <important> <p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>FilterExpression</i> instead. Do not
     *         combine legacy parameters and expression parameters in a single API
     *         call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. </important> <p>A condition that evaluates the scan results
     *         and returns only the desired values. <note><p>This parameter does not
     *         support attributes of type List or Map.</note> <p>If you specify more
     *         than one condition in the <i>ScanFilter</i> map, then by default all
     *         of the conditions must evaluate to true. In other words, the
     *         conditions are ANDed together. (You can use the
     *         <i>ConditionalOperator</i> parameter to OR the conditions instead. If
     *         you do this, then at least one of the conditions must evaluate to
     *         true, rather than all of them.) <p>Each <i>ScanFilter</i> element
     *         consists of an attribute name to compare, along with the following:
     *         <ul> <li> <p><i>AttributeValueList</i> - One or more values to
     *         evaluate against the supplied attribute. The number of values in the
     *         list depends on the operator specified in <i>ComparisonOperator</i> .
     *         <p>For type Number, value comparisons are numeric. <p>String value
     *         comparisons for greater than, equals, or less than are based on ASCII
     *         character code values. For example, <code>a</code> is greater than
     *         <code>A</code>, and <code>a</code> is greater than <code>B</code>. For
     *         a list of code values, see <a
     *         href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     *         <p>For Binary, DynamoDB treats each byte of the binary data as
     *         unsigned when it compares binary values. <p>For information on
     *         specifying data types in JSON, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON
     *         Data Format</a> in the <i>Amazon DynamoDB Developer Guide</i>. </li>
     *         <li><p><i>ComparisonOperator</i> - A comparator for evaluating
     *         attributes. For example, equals, greater than, less than, etc. <p>The
     *         following comparison operators are available: <p><code>EQ | NE | LE |
     *         LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH
     *         | IN | BETWEEN</code> <p>For complete descriptions of all comparison
     *         operators, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Condition.html">Condition</a>.
     *         </li> </ul>
     */
    public java.util.Map<String,Condition> getScanFilter() {
        
        return scanFilter;
    }
    
    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A condition that evaluates the scan results
     * and returns only the desired values. <note><p>This parameter does not
     * support attributes of type List or Map.</note> <p>If you specify more
     * than one condition in the <i>ScanFilter</i> map, then by default all
     * of the conditions must evaluate to true. In other words, the
     * conditions are ANDed together. (You can use the
     * <i>ConditionalOperator</i> parameter to OR the conditions instead. If
     * you do this, then at least one of the conditions must evaluate to
     * true, rather than all of them.) <p>Each <i>ScanFilter</i> element
     * consists of an attribute name to compare, along with the following:
     * <ul> <li> <p><i>AttributeValueList</i> - One or more values to
     * evaluate against the supplied attribute. The number of values in the
     * list depends on the operator specified in <i>ComparisonOperator</i> .
     * <p>For type Number, value comparisons are numeric. <p>String value
     * comparisons for greater than, equals, or less than are based on ASCII
     * character code values. For example, <code>a</code> is greater than
     * <code>A</code>, and <code>a</code> is greater than <code>B</code>. For
     * a list of code values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     * <p>For Binary, DynamoDB treats each byte of the binary data as
     * unsigned when it compares binary values. <p>For information on
     * specifying data types in JSON, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON
     * Data Format</a> in the <i>Amazon DynamoDB Developer Guide</i>. </li>
     * <li><p><i>ComparisonOperator</i> - A comparator for evaluating
     * attributes. For example, equals, greater than, less than, etc. <p>The
     * following comparison operators are available: <p><code>EQ | NE | LE |
     * LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH
     * | IN | BETWEEN</code> <p>For complete descriptions of all comparison
     * operators, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Condition.html">Condition</a>.
     * </li> </ul>
     *
     * @param scanFilter <important> <p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>FilterExpression</i> instead. Do not
     *         combine legacy parameters and expression parameters in a single API
     *         call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. </important> <p>A condition that evaluates the scan results
     *         and returns only the desired values. <note><p>This parameter does not
     *         support attributes of type List or Map.</note> <p>If you specify more
     *         than one condition in the <i>ScanFilter</i> map, then by default all
     *         of the conditions must evaluate to true. In other words, the
     *         conditions are ANDed together. (You can use the
     *         <i>ConditionalOperator</i> parameter to OR the conditions instead. If
     *         you do this, then at least one of the conditions must evaluate to
     *         true, rather than all of them.) <p>Each <i>ScanFilter</i> element
     *         consists of an attribute name to compare, along with the following:
     *         <ul> <li> <p><i>AttributeValueList</i> - One or more values to
     *         evaluate against the supplied attribute. The number of values in the
     *         list depends on the operator specified in <i>ComparisonOperator</i> .
     *         <p>For type Number, value comparisons are numeric. <p>String value
     *         comparisons for greater than, equals, or less than are based on ASCII
     *         character code values. For example, <code>a</code> is greater than
     *         <code>A</code>, and <code>a</code> is greater than <code>B</code>. For
     *         a list of code values, see <a
     *         href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     *         <p>For Binary, DynamoDB treats each byte of the binary data as
     *         unsigned when it compares binary values. <p>For information on
     *         specifying data types in JSON, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON
     *         Data Format</a> in the <i>Amazon DynamoDB Developer Guide</i>. </li>
     *         <li><p><i>ComparisonOperator</i> - A comparator for evaluating
     *         attributes. For example, equals, greater than, less than, etc. <p>The
     *         following comparison operators are available: <p><code>EQ | NE | LE |
     *         LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH
     *         | IN | BETWEEN</code> <p>For complete descriptions of all comparison
     *         operators, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Condition.html">Condition</a>.
     *         </li> </ul>
     */
    public void setScanFilter(java.util.Map<String,Condition> scanFilter) {
        this.scanFilter = scanFilter;
    }
    
    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A condition that evaluates the scan results
     * and returns only the desired values. <note><p>This parameter does not
     * support attributes of type List or Map.</note> <p>If you specify more
     * than one condition in the <i>ScanFilter</i> map, then by default all
     * of the conditions must evaluate to true. In other words, the
     * conditions are ANDed together. (You can use the
     * <i>ConditionalOperator</i> parameter to OR the conditions instead. If
     * you do this, then at least one of the conditions must evaluate to
     * true, rather than all of them.) <p>Each <i>ScanFilter</i> element
     * consists of an attribute name to compare, along with the following:
     * <ul> <li> <p><i>AttributeValueList</i> - One or more values to
     * evaluate against the supplied attribute. The number of values in the
     * list depends on the operator specified in <i>ComparisonOperator</i> .
     * <p>For type Number, value comparisons are numeric. <p>String value
     * comparisons for greater than, equals, or less than are based on ASCII
     * character code values. For example, <code>a</code> is greater than
     * <code>A</code>, and <code>a</code> is greater than <code>B</code>. For
     * a list of code values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     * <p>For Binary, DynamoDB treats each byte of the binary data as
     * unsigned when it compares binary values. <p>For information on
     * specifying data types in JSON, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON
     * Data Format</a> in the <i>Amazon DynamoDB Developer Guide</i>. </li>
     * <li><p><i>ComparisonOperator</i> - A comparator for evaluating
     * attributes. For example, equals, greater than, less than, etc. <p>The
     * following comparison operators are available: <p><code>EQ | NE | LE |
     * LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH
     * | IN | BETWEEN</code> <p>For complete descriptions of all comparison
     * operators, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Condition.html">Condition</a>.
     * </li> </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param scanFilter <important> <p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>FilterExpression</i> instead. Do not
     *         combine legacy parameters and expression parameters in a single API
     *         call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. </important> <p>A condition that evaluates the scan results
     *         and returns only the desired values. <note><p>This parameter does not
     *         support attributes of type List or Map.</note> <p>If you specify more
     *         than one condition in the <i>ScanFilter</i> map, then by default all
     *         of the conditions must evaluate to true. In other words, the
     *         conditions are ANDed together. (You can use the
     *         <i>ConditionalOperator</i> parameter to OR the conditions instead. If
     *         you do this, then at least one of the conditions must evaluate to
     *         true, rather than all of them.) <p>Each <i>ScanFilter</i> element
     *         consists of an attribute name to compare, along with the following:
     *         <ul> <li> <p><i>AttributeValueList</i> - One or more values to
     *         evaluate against the supplied attribute. The number of values in the
     *         list depends on the operator specified in <i>ComparisonOperator</i> .
     *         <p>For type Number, value comparisons are numeric. <p>String value
     *         comparisons for greater than, equals, or less than are based on ASCII
     *         character code values. For example, <code>a</code> is greater than
     *         <code>A</code>, and <code>a</code> is greater than <code>B</code>. For
     *         a list of code values, see <a
     *         href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     *         <p>For Binary, DynamoDB treats each byte of the binary data as
     *         unsigned when it compares binary values. <p>For information on
     *         specifying data types in JSON, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON
     *         Data Format</a> in the <i>Amazon DynamoDB Developer Guide</i>. </li>
     *         <li><p><i>ComparisonOperator</i> - A comparator for evaluating
     *         attributes. For example, equals, greater than, less than, etc. <p>The
     *         following comparison operators are available: <p><code>EQ | NE | LE |
     *         LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH
     *         | IN | BETWEEN</code> <p>For complete descriptions of all comparison
     *         operators, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Condition.html">Condition</a>.
     *         </li> </ul>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withScanFilter(java.util.Map<String,Condition> scanFilter) {
        setScanFilter(scanFilter);
        return this;
    }

    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A condition that evaluates the scan results
     * and returns only the desired values. <note><p>This parameter does not
     * support attributes of type List or Map.</note> <p>If you specify more
     * than one condition in the <i>ScanFilter</i> map, then by default all
     * of the conditions must evaluate to true. In other words, the
     * conditions are ANDed together. (You can use the
     * <i>ConditionalOperator</i> parameter to OR the conditions instead. If
     * you do this, then at least one of the conditions must evaluate to
     * true, rather than all of them.) <p>Each <i>ScanFilter</i> element
     * consists of an attribute name to compare, along with the following:
     * <ul> <li> <p><i>AttributeValueList</i> - One or more values to
     * evaluate against the supplied attribute. The number of values in the
     * list depends on the operator specified in <i>ComparisonOperator</i> .
     * <p>For type Number, value comparisons are numeric. <p>String value
     * comparisons for greater than, equals, or less than are based on ASCII
     * character code values. For example, <code>a</code> is greater than
     * <code>A</code>, and <code>a</code> is greater than <code>B</code>. For
     * a list of code values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     * <p>For Binary, DynamoDB treats each byte of the binary data as
     * unsigned when it compares binary values. <p>For information on
     * specifying data types in JSON, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON
     * Data Format</a> in the <i>Amazon DynamoDB Developer Guide</i>. </li>
     * <li><p><i>ComparisonOperator</i> - A comparator for evaluating
     * attributes. For example, equals, greater than, less than, etc. <p>The
     * following comparison operators are available: <p><code>EQ | NE | LE |
     * LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH
     * | IN | BETWEEN</code> <p>For complete descriptions of all comparison
     * operators, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_Condition.html">Condition</a>.
     * </li> </ul>
     * <p>
     * The method adds a new key-value pair into ScanFilter parameter, and
     * returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param key The key of the entry to be added into ScanFilter.
     * @param value The corresponding value of the entry to be added into ScanFilter.
     */
    public ScanRequest addScanFilterEntry(String key, Condition value) {
        if (null == this.scanFilter) {
            this.scanFilter = new java.util.HashMap<String,Condition>();
        }
        if (this.scanFilter.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.scanFilter.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ScanFilter.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public ScanRequest clearScanFilterEntries() {
        this.scanFilter = null;
        return this;
    }
    
    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A logical operator to apply to the
     * conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     * If all of the conditions evaluate to true, then the entire map
     * evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     * the conditions evaluate to true, then the entire map evaluates to
     * true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     * <code>AND</code> is the default. <p>The operation will succeed only if
     * the entire map evaluates to true. <note><p>This parameter does not
     * support attributes of type List or Map.</note>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>AND, OR
     *
     * @return <important> <p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>FilterExpression</i> instead. Do not
     *         combine legacy parameters and expression parameters in a single API
     *         call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. </important> <p>A logical operator to apply to the
     *         conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     *         If all of the conditions evaluate to true, then the entire map
     *         evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     *         the conditions evaluate to true, then the entire map evaluates to
     *         true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     *         <code>AND</code> is the default. <p>The operation will succeed only if
     *         the entire map evaluates to true. <note><p>This parameter does not
     *         support attributes of type List or Map.</note>
     *
     * @see ConditionalOperator
     */
    public String getConditionalOperator() {
        return conditionalOperator;
    }
    
    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A logical operator to apply to the
     * conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     * If all of the conditions evaluate to true, then the entire map
     * evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     * the conditions evaluate to true, then the entire map evaluates to
     * true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     * <code>AND</code> is the default. <p>The operation will succeed only if
     * the entire map evaluates to true. <note><p>This parameter does not
     * support attributes of type List or Map.</note>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>AND, OR
     *
     * @param conditionalOperator <important> <p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>FilterExpression</i> instead. Do not
     *         combine legacy parameters and expression parameters in a single API
     *         call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. </important> <p>A logical operator to apply to the
     *         conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     *         If all of the conditions evaluate to true, then the entire map
     *         evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     *         the conditions evaluate to true, then the entire map evaluates to
     *         true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     *         <code>AND</code> is the default. <p>The operation will succeed only if
     *         the entire map evaluates to true. <note><p>This parameter does not
     *         support attributes of type List or Map.</note>
     *
     * @see ConditionalOperator
     */
    public void setConditionalOperator(String conditionalOperator) {
        this.conditionalOperator = conditionalOperator;
    }
    
    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A logical operator to apply to the
     * conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     * If all of the conditions evaluate to true, then the entire map
     * evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     * the conditions evaluate to true, then the entire map evaluates to
     * true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     * <code>AND</code> is the default. <p>The operation will succeed only if
     * the entire map evaluates to true. <note><p>This parameter does not
     * support attributes of type List or Map.</note>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>AND, OR
     *
     * @param conditionalOperator <important> <p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>FilterExpression</i> instead. Do not
     *         combine legacy parameters and expression parameters in a single API
     *         call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. </important> <p>A logical operator to apply to the
     *         conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     *         If all of the conditions evaluate to true, then the entire map
     *         evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     *         the conditions evaluate to true, then the entire map evaluates to
     *         true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     *         <code>AND</code> is the default. <p>The operation will succeed only if
     *         the entire map evaluates to true. <note><p>This parameter does not
     *         support attributes of type List or Map.</note>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see ConditionalOperator
     */
    public ScanRequest withConditionalOperator(String conditionalOperator) {
        this.conditionalOperator = conditionalOperator;
        return this;
    }

    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A logical operator to apply to the
     * conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     * If all of the conditions evaluate to true, then the entire map
     * evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     * the conditions evaluate to true, then the entire map evaluates to
     * true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     * <code>AND</code> is the default. <p>The operation will succeed only if
     * the entire map evaluates to true. <note><p>This parameter does not
     * support attributes of type List or Map.</note>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>AND, OR
     *
     * @param conditionalOperator <important> <p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>FilterExpression</i> instead. Do not
     *         combine legacy parameters and expression parameters in a single API
     *         call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. </important> <p>A logical operator to apply to the
     *         conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     *         If all of the conditions evaluate to true, then the entire map
     *         evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     *         the conditions evaluate to true, then the entire map evaluates to
     *         true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     *         <code>AND</code> is the default. <p>The operation will succeed only if
     *         the entire map evaluates to true. <note><p>This parameter does not
     *         support attributes of type List or Map.</note>
     *
     * @see ConditionalOperator
     */
    public void setConditionalOperator(ConditionalOperator conditionalOperator) {
        this.conditionalOperator = conditionalOperator.toString();
    }
    
    /**
     * <important> <p>This is a legacy parameter, for backward compatibility.
     * New applications should use <i>FilterExpression</i> instead. Do not
     * combine legacy parameters and expression parameters in a single API
     * call; otherwise, DynamoDB will return a <i>ValidationException</i>
     * exception. </important> <p>A logical operator to apply to the
     * conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     * If all of the conditions evaluate to true, then the entire map
     * evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     * the conditions evaluate to true, then the entire map evaluates to
     * true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     * <code>AND</code> is the default. <p>The operation will succeed only if
     * the entire map evaluates to true. <note><p>This parameter does not
     * support attributes of type List or Map.</note>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>AND, OR
     *
     * @param conditionalOperator <important> <p>This is a legacy parameter, for backward compatibility.
     *         New applications should use <i>FilterExpression</i> instead. Do not
     *         combine legacy parameters and expression parameters in a single API
     *         call; otherwise, DynamoDB will return a <i>ValidationException</i>
     *         exception. </important> <p>A logical operator to apply to the
     *         conditions in a <i>ScanFilter</i> map: <ul> <li><p><code>AND</code> -
     *         If all of the conditions evaluate to true, then the entire map
     *         evaluates to true.</li> <li><p><code>OR</code> - If at least one of
     *         the conditions evaluate to true, then the entire map evaluates to
     *         true.</li> </ul> <p>If you omit <i>ConditionalOperator</i>, then
     *         <code>AND</code> is the default. <p>The operation will succeed only if
     *         the entire map evaluates to true. <note><p>This parameter does not
     *         support attributes of type List or Map.</note>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see ConditionalOperator
     */
    public ScanRequest withConditionalOperator(ConditionalOperator conditionalOperator) {
        this.conditionalOperator = conditionalOperator.toString();
        return this;
    }

    /**
     * The primary key of the first item that this operation will evaluate.
     * Use the value that was returned for <i>LastEvaluatedKey</i> in the
     * previous operation. <p>The data type for <i>ExclusiveStartKey</i> must
     * be String, Number or Binary. No set data types are allowed. <p>In a
     * parallel scan, a <i>Scan</i> request that includes
     * <i>ExclusiveStartKey</i> must specify the same segment whose previous
     * <i>Scan</i> returned the corresponding value of
     * <i>LastEvaluatedKey</i>.
     *
     * @return The primary key of the first item that this operation will evaluate.
     *         Use the value that was returned for <i>LastEvaluatedKey</i> in the
     *         previous operation. <p>The data type for <i>ExclusiveStartKey</i> must
     *         be String, Number or Binary. No set data types are allowed. <p>In a
     *         parallel scan, a <i>Scan</i> request that includes
     *         <i>ExclusiveStartKey</i> must specify the same segment whose previous
     *         <i>Scan</i> returned the corresponding value of
     *         <i>LastEvaluatedKey</i>.
     */
    public java.util.Map<String,AttributeValue> getExclusiveStartKey() {
        
        return exclusiveStartKey;
    }
    
    /**
     * The primary key of the first item that this operation will evaluate.
     * Use the value that was returned for <i>LastEvaluatedKey</i> in the
     * previous operation. <p>The data type for <i>ExclusiveStartKey</i> must
     * be String, Number or Binary. No set data types are allowed. <p>In a
     * parallel scan, a <i>Scan</i> request that includes
     * <i>ExclusiveStartKey</i> must specify the same segment whose previous
     * <i>Scan</i> returned the corresponding value of
     * <i>LastEvaluatedKey</i>.
     *
     * @param exclusiveStartKey The primary key of the first item that this operation will evaluate.
     *         Use the value that was returned for <i>LastEvaluatedKey</i> in the
     *         previous operation. <p>The data type for <i>ExclusiveStartKey</i> must
     *         be String, Number or Binary. No set data types are allowed. <p>In a
     *         parallel scan, a <i>Scan</i> request that includes
     *         <i>ExclusiveStartKey</i> must specify the same segment whose previous
     *         <i>Scan</i> returned the corresponding value of
     *         <i>LastEvaluatedKey</i>.
     */
    public void setExclusiveStartKey(java.util.Map<String,AttributeValue> exclusiveStartKey) {
        this.exclusiveStartKey = exclusiveStartKey;
    }
    
    /**
     * The primary key of the first item that this operation will evaluate.
     * Use the value that was returned for <i>LastEvaluatedKey</i> in the
     * previous operation. <p>The data type for <i>ExclusiveStartKey</i> must
     * be String, Number or Binary. No set data types are allowed. <p>In a
     * parallel scan, a <i>Scan</i> request that includes
     * <i>ExclusiveStartKey</i> must specify the same segment whose previous
     * <i>Scan</i> returned the corresponding value of
     * <i>LastEvaluatedKey</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param exclusiveStartKey The primary key of the first item that this operation will evaluate.
     *         Use the value that was returned for <i>LastEvaluatedKey</i> in the
     *         previous operation. <p>The data type for <i>ExclusiveStartKey</i> must
     *         be String, Number or Binary. No set data types are allowed. <p>In a
     *         parallel scan, a <i>Scan</i> request that includes
     *         <i>ExclusiveStartKey</i> must specify the same segment whose previous
     *         <i>Scan</i> returned the corresponding value of
     *         <i>LastEvaluatedKey</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withExclusiveStartKey(java.util.Map<String,AttributeValue> exclusiveStartKey) {
        setExclusiveStartKey(exclusiveStartKey);
        return this;
    }

    /**
     * The primary key of the first item that this operation will evaluate.
     * Use the value that was returned for <i>LastEvaluatedKey</i> in the
     * previous operation. <p>The data type for <i>ExclusiveStartKey</i> must
     * be String, Number or Binary. No set data types are allowed. <p>In a
     * parallel scan, a <i>Scan</i> request that includes
     * <i>ExclusiveStartKey</i> must specify the same segment whose previous
     * <i>Scan</i> returned the corresponding value of
     * <i>LastEvaluatedKey</i>.
     * <p>
     * This method accepts the hashKey, rangeKey of ExclusiveStartKey as
     * java.util.Map.Entry<String, AttributeValue> objects.
     *
     * @param hashKey Primary hash key.
     * @param rangeKey Primary range key. (null if it a hash-only table)
     */
    public void setExclusiveStartKey(java.util.Map.Entry<String, AttributeValue> hashKey, java.util.Map.Entry<String, AttributeValue> rangeKey) throws IllegalArgumentException {
        java.util.HashMap<String,AttributeValue> exclusiveStartKey = new java.util.HashMap<String,AttributeValue>();
        
        if (hashKey != null) {
            exclusiveStartKey.put(hashKey.getKey(), hashKey.getValue());
        } else
            throw new IllegalArgumentException("hashKey must be non-null object.");
        if (rangeKey != null) {
            exclusiveStartKey.put(rangeKey.getKey(), rangeKey.getValue());
        } 
        setExclusiveStartKey(exclusiveStartKey);
    }
    
    /**
     * The primary key of the first item that this operation will evaluate.
     * Use the value that was returned for <i>LastEvaluatedKey</i> in the
     * previous operation. <p>The data type for <i>ExclusiveStartKey</i> must
     * be String, Number or Binary. No set data types are allowed. <p>In a
     * parallel scan, a <i>Scan</i> request that includes
     * <i>ExclusiveStartKey</i> must specify the same segment whose previous
     * <i>Scan</i> returned the corresponding value of
     * <i>LastEvaluatedKey</i>.
     * <p>
     * This method accepts the hashKey, rangeKey of ExclusiveStartKey as
     * java.util.Map.Entry<String, AttributeValue> objects.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param hashKey Primary hash key.
     * @param rangeKey Primary range key. (null if it a hash-only table)
     */
    public ScanRequest withExclusiveStartKey(java.util.Map.Entry<String, AttributeValue> hashKey, java.util.Map.Entry<String, AttributeValue> rangeKey) throws IllegalArgumentException {
        setExclusiveStartKey(hashKey, rangeKey);
        return this;
    }

    /**
     * The primary key of the first item that this operation will evaluate.
     * Use the value that was returned for <i>LastEvaluatedKey</i> in the
     * previous operation. <p>The data type for <i>ExclusiveStartKey</i> must
     * be String, Number or Binary. No set data types are allowed. <p>In a
     * parallel scan, a <i>Scan</i> request that includes
     * <i>ExclusiveStartKey</i> must specify the same segment whose previous
     * <i>Scan</i> returned the corresponding value of
     * <i>LastEvaluatedKey</i>.
     * <p>
     * The method adds a new key-value pair into ExclusiveStartKey parameter,
     * and returns a reference to this object so that method calls can be
     * chained together.
     *
     * @param key The key of the entry to be added into ExclusiveStartKey.
     * @param value The corresponding value of the entry to be added into ExclusiveStartKey.
     */
    public ScanRequest addExclusiveStartKeyEntry(String key, AttributeValue value) {
        if (null == this.exclusiveStartKey) {
            this.exclusiveStartKey = new java.util.HashMap<String,AttributeValue>();
        }
        if (this.exclusiveStartKey.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.exclusiveStartKey.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ExclusiveStartKey.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public ScanRequest clearExclusiveStartKeyEntries() {
        this.exclusiveStartKey = null;
        return this;
    }
    
    /**
     * Determines the level of detail about provisioned throughput
     * consumption that is returned in the response: <ul>
     * <li><p><i>INDEXES</i> - The response includes the aggregate
     * <i>ConsumedCapacity</i> for the operation, together with
     * <i>ConsumedCapacity</i> for each table and secondary index that was
     * accessed. <p>Note that some operations, such as <i>GetItem</i> and
     * <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     * specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     * information for table(s).</li> <li><p><i>TOTAL</i> - The response
     * includes only the aggregate <i>ConsumedCapacity</i> for the
     * operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     * details are included in the response.</li> </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INDEXES, TOTAL, NONE
     *
     * @return Determines the level of detail about provisioned throughput
     *         consumption that is returned in the response: <ul>
     *         <li><p><i>INDEXES</i> - The response includes the aggregate
     *         <i>ConsumedCapacity</i> for the operation, together with
     *         <i>ConsumedCapacity</i> for each table and secondary index that was
     *         accessed. <p>Note that some operations, such as <i>GetItem</i> and
     *         <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     *         specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     *         information for table(s).</li> <li><p><i>TOTAL</i> - The response
     *         includes only the aggregate <i>ConsumedCapacity</i> for the
     *         operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     *         details are included in the response.</li> </ul>
     *
     * @see ReturnConsumedCapacity
     */
    public String getReturnConsumedCapacity() {
        return returnConsumedCapacity;
    }
    
    /**
     * Determines the level of detail about provisioned throughput
     * consumption that is returned in the response: <ul>
     * <li><p><i>INDEXES</i> - The response includes the aggregate
     * <i>ConsumedCapacity</i> for the operation, together with
     * <i>ConsumedCapacity</i> for each table and secondary index that was
     * accessed. <p>Note that some operations, such as <i>GetItem</i> and
     * <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     * specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     * information for table(s).</li> <li><p><i>TOTAL</i> - The response
     * includes only the aggregate <i>ConsumedCapacity</i> for the
     * operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     * details are included in the response.</li> </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INDEXES, TOTAL, NONE
     *
     * @param returnConsumedCapacity Determines the level of detail about provisioned throughput
     *         consumption that is returned in the response: <ul>
     *         <li><p><i>INDEXES</i> - The response includes the aggregate
     *         <i>ConsumedCapacity</i> for the operation, together with
     *         <i>ConsumedCapacity</i> for each table and secondary index that was
     *         accessed. <p>Note that some operations, such as <i>GetItem</i> and
     *         <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     *         specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     *         information for table(s).</li> <li><p><i>TOTAL</i> - The response
     *         includes only the aggregate <i>ConsumedCapacity</i> for the
     *         operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     *         details are included in the response.</li> </ul>
     *
     * @see ReturnConsumedCapacity
     */
    public void setReturnConsumedCapacity(String returnConsumedCapacity) {
        this.returnConsumedCapacity = returnConsumedCapacity;
    }
    
    /**
     * Determines the level of detail about provisioned throughput
     * consumption that is returned in the response: <ul>
     * <li><p><i>INDEXES</i> - The response includes the aggregate
     * <i>ConsumedCapacity</i> for the operation, together with
     * <i>ConsumedCapacity</i> for each table and secondary index that was
     * accessed. <p>Note that some operations, such as <i>GetItem</i> and
     * <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     * specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     * information for table(s).</li> <li><p><i>TOTAL</i> - The response
     * includes only the aggregate <i>ConsumedCapacity</i> for the
     * operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     * details are included in the response.</li> </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INDEXES, TOTAL, NONE
     *
     * @param returnConsumedCapacity Determines the level of detail about provisioned throughput
     *         consumption that is returned in the response: <ul>
     *         <li><p><i>INDEXES</i> - The response includes the aggregate
     *         <i>ConsumedCapacity</i> for the operation, together with
     *         <i>ConsumedCapacity</i> for each table and secondary index that was
     *         accessed. <p>Note that some operations, such as <i>GetItem</i> and
     *         <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     *         specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     *         information for table(s).</li> <li><p><i>TOTAL</i> - The response
     *         includes only the aggregate <i>ConsumedCapacity</i> for the
     *         operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     *         details are included in the response.</li> </ul>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see ReturnConsumedCapacity
     */
    public ScanRequest withReturnConsumedCapacity(String returnConsumedCapacity) {
        this.returnConsumedCapacity = returnConsumedCapacity;
        return this;
    }

    /**
     * Determines the level of detail about provisioned throughput
     * consumption that is returned in the response: <ul>
     * <li><p><i>INDEXES</i> - The response includes the aggregate
     * <i>ConsumedCapacity</i> for the operation, together with
     * <i>ConsumedCapacity</i> for each table and secondary index that was
     * accessed. <p>Note that some operations, such as <i>GetItem</i> and
     * <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     * specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     * information for table(s).</li> <li><p><i>TOTAL</i> - The response
     * includes only the aggregate <i>ConsumedCapacity</i> for the
     * operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     * details are included in the response.</li> </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INDEXES, TOTAL, NONE
     *
     * @param returnConsumedCapacity Determines the level of detail about provisioned throughput
     *         consumption that is returned in the response: <ul>
     *         <li><p><i>INDEXES</i> - The response includes the aggregate
     *         <i>ConsumedCapacity</i> for the operation, together with
     *         <i>ConsumedCapacity</i> for each table and secondary index that was
     *         accessed. <p>Note that some operations, such as <i>GetItem</i> and
     *         <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     *         specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     *         information for table(s).</li> <li><p><i>TOTAL</i> - The response
     *         includes only the aggregate <i>ConsumedCapacity</i> for the
     *         operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     *         details are included in the response.</li> </ul>
     *
     * @see ReturnConsumedCapacity
     */
    public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        this.returnConsumedCapacity = returnConsumedCapacity.toString();
    }
    
    /**
     * Determines the level of detail about provisioned throughput
     * consumption that is returned in the response: <ul>
     * <li><p><i>INDEXES</i> - The response includes the aggregate
     * <i>ConsumedCapacity</i> for the operation, together with
     * <i>ConsumedCapacity</i> for each table and secondary index that was
     * accessed. <p>Note that some operations, such as <i>GetItem</i> and
     * <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     * specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     * information for table(s).</li> <li><p><i>TOTAL</i> - The response
     * includes only the aggregate <i>ConsumedCapacity</i> for the
     * operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     * details are included in the response.</li> </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>INDEXES, TOTAL, NONE
     *
     * @param returnConsumedCapacity Determines the level of detail about provisioned throughput
     *         consumption that is returned in the response: <ul>
     *         <li><p><i>INDEXES</i> - The response includes the aggregate
     *         <i>ConsumedCapacity</i> for the operation, together with
     *         <i>ConsumedCapacity</i> for each table and secondary index that was
     *         accessed. <p>Note that some operations, such as <i>GetItem</i> and
     *         <i>BatchGetItem</i>, do not access any indexes at all. In these cases,
     *         specifying <i>INDEXES</i> will only return <i>ConsumedCapacity</i>
     *         information for table(s).</li> <li><p><i>TOTAL</i> - The response
     *         includes only the aggregate <i>ConsumedCapacity</i> for the
     *         operation.</li> <li><p><i>NONE</i> - No <i>ConsumedCapacity</i>
     *         details are included in the response.</li> </ul>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see ReturnConsumedCapacity
     */
    public ScanRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        this.returnConsumedCapacity = returnConsumedCapacity.toString();
        return this;
    }

    /**
     * For a parallel <i>Scan</i> request, <i>TotalSegments</i> represents
     * the total number of segments into which the <i>Scan</i> operation will
     * be divided. The value of <i>TotalSegments</i> corresponds to the
     * number of application workers that will perform the parallel scan. For
     * example, if you want to use four application threads to scan a table
     * or an index, specify a <i>TotalSegments</i> value of 4. <p>The value
     * for <i>TotalSegments</i> must be greater than or equal to 1, and less
     * than or equal to 1000000. If you specify a <i>TotalSegments</i> value
     * of 1, the <i>Scan</i> operation will be sequential rather than
     * parallel. <p>If you specify <i>TotalSegments</i>, you must also
     * specify <i>Segment</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - 1000000<br/>
     *
     * @return For a parallel <i>Scan</i> request, <i>TotalSegments</i> represents
     *         the total number of segments into which the <i>Scan</i> operation will
     *         be divided. The value of <i>TotalSegments</i> corresponds to the
     *         number of application workers that will perform the parallel scan. For
     *         example, if you want to use four application threads to scan a table
     *         or an index, specify a <i>TotalSegments</i> value of 4. <p>The value
     *         for <i>TotalSegments</i> must be greater than or equal to 1, and less
     *         than or equal to 1000000. If you specify a <i>TotalSegments</i> value
     *         of 1, the <i>Scan</i> operation will be sequential rather than
     *         parallel. <p>If you specify <i>TotalSegments</i>, you must also
     *         specify <i>Segment</i>.
     */
    public Integer getTotalSegments() {
        return totalSegments;
    }
    
    /**
     * For a parallel <i>Scan</i> request, <i>TotalSegments</i> represents
     * the total number of segments into which the <i>Scan</i> operation will
     * be divided. The value of <i>TotalSegments</i> corresponds to the
     * number of application workers that will perform the parallel scan. For
     * example, if you want to use four application threads to scan a table
     * or an index, specify a <i>TotalSegments</i> value of 4. <p>The value
     * for <i>TotalSegments</i> must be greater than or equal to 1, and less
     * than or equal to 1000000. If you specify a <i>TotalSegments</i> value
     * of 1, the <i>Scan</i> operation will be sequential rather than
     * parallel. <p>If you specify <i>TotalSegments</i>, you must also
     * specify <i>Segment</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - 1000000<br/>
     *
     * @param totalSegments For a parallel <i>Scan</i> request, <i>TotalSegments</i> represents
     *         the total number of segments into which the <i>Scan</i> operation will
     *         be divided. The value of <i>TotalSegments</i> corresponds to the
     *         number of application workers that will perform the parallel scan. For
     *         example, if you want to use four application threads to scan a table
     *         or an index, specify a <i>TotalSegments</i> value of 4. <p>The value
     *         for <i>TotalSegments</i> must be greater than or equal to 1, and less
     *         than or equal to 1000000. If you specify a <i>TotalSegments</i> value
     *         of 1, the <i>Scan</i> operation will be sequential rather than
     *         parallel. <p>If you specify <i>TotalSegments</i>, you must also
     *         specify <i>Segment</i>.
     */
    public void setTotalSegments(Integer totalSegments) {
        this.totalSegments = totalSegments;
    }
    
    /**
     * For a parallel <i>Scan</i> request, <i>TotalSegments</i> represents
     * the total number of segments into which the <i>Scan</i> operation will
     * be divided. The value of <i>TotalSegments</i> corresponds to the
     * number of application workers that will perform the parallel scan. For
     * example, if you want to use four application threads to scan a table
     * or an index, specify a <i>TotalSegments</i> value of 4. <p>The value
     * for <i>TotalSegments</i> must be greater than or equal to 1, and less
     * than or equal to 1000000. If you specify a <i>TotalSegments</i> value
     * of 1, the <i>Scan</i> operation will be sequential rather than
     * parallel. <p>If you specify <i>TotalSegments</i>, you must also
     * specify <i>Segment</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - 1000000<br/>
     *
     * @param totalSegments For a parallel <i>Scan</i> request, <i>TotalSegments</i> represents
     *         the total number of segments into which the <i>Scan</i> operation will
     *         be divided. The value of <i>TotalSegments</i> corresponds to the
     *         number of application workers that will perform the parallel scan. For
     *         example, if you want to use four application threads to scan a table
     *         or an index, specify a <i>TotalSegments</i> value of 4. <p>The value
     *         for <i>TotalSegments</i> must be greater than or equal to 1, and less
     *         than or equal to 1000000. If you specify a <i>TotalSegments</i> value
     *         of 1, the <i>Scan</i> operation will be sequential rather than
     *         parallel. <p>If you specify <i>TotalSegments</i>, you must also
     *         specify <i>Segment</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withTotalSegments(Integer totalSegments) {
        this.totalSegments = totalSegments;
        return this;
    }

    /**
     * For a parallel <i>Scan</i> request, <i>Segment</i> identifies an
     * individual segment to be scanned by an application worker. <p>Segment
     * IDs are zero-based, so the first segment is always 0. For example, if
     * you want to use four application threads to scan a table or an index,
     * then the first thread specifies a <i>Segment</i> value of 0, the
     * second thread specifies 1, and so on. <p>The value of
     * <i>LastEvaluatedKey</i> returned from a parallel <i>Scan</i> request
     * must be used as <i>ExclusiveStartKey</i> with the same segment ID in a
     * subsequent <i>Scan</i> operation. <p>The value for <i>Segment</i> must
     * be greater than or equal to 0, and less than the value provided for
     * <i>TotalSegments</i>. <p>If you provide <i>Segment</i>, you must also
     * provide <i>TotalSegments</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>0 - 999999<br/>
     *
     * @return For a parallel <i>Scan</i> request, <i>Segment</i> identifies an
     *         individual segment to be scanned by an application worker. <p>Segment
     *         IDs are zero-based, so the first segment is always 0. For example, if
     *         you want to use four application threads to scan a table or an index,
     *         then the first thread specifies a <i>Segment</i> value of 0, the
     *         second thread specifies 1, and so on. <p>The value of
     *         <i>LastEvaluatedKey</i> returned from a parallel <i>Scan</i> request
     *         must be used as <i>ExclusiveStartKey</i> with the same segment ID in a
     *         subsequent <i>Scan</i> operation. <p>The value for <i>Segment</i> must
     *         be greater than or equal to 0, and less than the value provided for
     *         <i>TotalSegments</i>. <p>If you provide <i>Segment</i>, you must also
     *         provide <i>TotalSegments</i>.
     */
    public Integer getSegment() {
        return segment;
    }
    
    /**
     * For a parallel <i>Scan</i> request, <i>Segment</i> identifies an
     * individual segment to be scanned by an application worker. <p>Segment
     * IDs are zero-based, so the first segment is always 0. For example, if
     * you want to use four application threads to scan a table or an index,
     * then the first thread specifies a <i>Segment</i> value of 0, the
     * second thread specifies 1, and so on. <p>The value of
     * <i>LastEvaluatedKey</i> returned from a parallel <i>Scan</i> request
     * must be used as <i>ExclusiveStartKey</i> with the same segment ID in a
     * subsequent <i>Scan</i> operation. <p>The value for <i>Segment</i> must
     * be greater than or equal to 0, and less than the value provided for
     * <i>TotalSegments</i>. <p>If you provide <i>Segment</i>, you must also
     * provide <i>TotalSegments</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>0 - 999999<br/>
     *
     * @param segment For a parallel <i>Scan</i> request, <i>Segment</i> identifies an
     *         individual segment to be scanned by an application worker. <p>Segment
     *         IDs are zero-based, so the first segment is always 0. For example, if
     *         you want to use four application threads to scan a table or an index,
     *         then the first thread specifies a <i>Segment</i> value of 0, the
     *         second thread specifies 1, and so on. <p>The value of
     *         <i>LastEvaluatedKey</i> returned from a parallel <i>Scan</i> request
     *         must be used as <i>ExclusiveStartKey</i> with the same segment ID in a
     *         subsequent <i>Scan</i> operation. <p>The value for <i>Segment</i> must
     *         be greater than or equal to 0, and less than the value provided for
     *         <i>TotalSegments</i>. <p>If you provide <i>Segment</i>, you must also
     *         provide <i>TotalSegments</i>.
     */
    public void setSegment(Integer segment) {
        this.segment = segment;
    }
    
    /**
     * For a parallel <i>Scan</i> request, <i>Segment</i> identifies an
     * individual segment to be scanned by an application worker. <p>Segment
     * IDs are zero-based, so the first segment is always 0. For example, if
     * you want to use four application threads to scan a table or an index,
     * then the first thread specifies a <i>Segment</i> value of 0, the
     * second thread specifies 1, and so on. <p>The value of
     * <i>LastEvaluatedKey</i> returned from a parallel <i>Scan</i> request
     * must be used as <i>ExclusiveStartKey</i> with the same segment ID in a
     * subsequent <i>Scan</i> operation. <p>The value for <i>Segment</i> must
     * be greater than or equal to 0, and less than the value provided for
     * <i>TotalSegments</i>. <p>If you provide <i>Segment</i>, you must also
     * provide <i>TotalSegments</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>0 - 999999<br/>
     *
     * @param segment For a parallel <i>Scan</i> request, <i>Segment</i> identifies an
     *         individual segment to be scanned by an application worker. <p>Segment
     *         IDs are zero-based, so the first segment is always 0. For example, if
     *         you want to use four application threads to scan a table or an index,
     *         then the first thread specifies a <i>Segment</i> value of 0, the
     *         second thread specifies 1, and so on. <p>The value of
     *         <i>LastEvaluatedKey</i> returned from a parallel <i>Scan</i> request
     *         must be used as <i>ExclusiveStartKey</i> with the same segment ID in a
     *         subsequent <i>Scan</i> operation. <p>The value for <i>Segment</i> must
     *         be greater than or equal to 0, and less than the value provided for
     *         <i>TotalSegments</i>. <p>If you provide <i>Segment</i>, you must also
     *         provide <i>TotalSegments</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withSegment(Integer segment) {
        this.segment = segment;
        return this;
    }

    /**
     * A string that identifies one or more attributes to retrieve from the
     * specified table or index. These attributes can include scalars, sets,
     * or elements of a JSON document. The attributes in the expression must
     * be separated by commas. <p>If no attribute names are specified, then
     * all attributes will be returned. If any of the requested attributes
     * are not found, they will not appear in the result. <p>For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     * Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <note><p><i>ProjectionExpression</i> replaces the legacy
     * <i>AttributesToGet</i> parameter.</note>
     *
     * @return A string that identifies one or more attributes to retrieve from the
     *         specified table or index. These attributes can include scalars, sets,
     *         or elements of a JSON document. The attributes in the expression must
     *         be separated by commas. <p>If no attribute names are specified, then
     *         all attributes will be returned. If any of the requested attributes
     *         are not found, they will not appear in the result. <p>For more
     *         information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     *         Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *         <note><p><i>ProjectionExpression</i> replaces the legacy
     *         <i>AttributesToGet</i> parameter.</note>
     */
    public String getProjectionExpression() {
        return projectionExpression;
    }
    
    /**
     * A string that identifies one or more attributes to retrieve from the
     * specified table or index. These attributes can include scalars, sets,
     * or elements of a JSON document. The attributes in the expression must
     * be separated by commas. <p>If no attribute names are specified, then
     * all attributes will be returned. If any of the requested attributes
     * are not found, they will not appear in the result. <p>For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     * Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <note><p><i>ProjectionExpression</i> replaces the legacy
     * <i>AttributesToGet</i> parameter.</note>
     *
     * @param projectionExpression A string that identifies one or more attributes to retrieve from the
     *         specified table or index. These attributes can include scalars, sets,
     *         or elements of a JSON document. The attributes in the expression must
     *         be separated by commas. <p>If no attribute names are specified, then
     *         all attributes will be returned. If any of the requested attributes
     *         are not found, they will not appear in the result. <p>For more
     *         information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     *         Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *         <note><p><i>ProjectionExpression</i> replaces the legacy
     *         <i>AttributesToGet</i> parameter.</note>
     */
    public void setProjectionExpression(String projectionExpression) {
        this.projectionExpression = projectionExpression;
    }
    
    /**
     * A string that identifies one or more attributes to retrieve from the
     * specified table or index. These attributes can include scalars, sets,
     * or elements of a JSON document. The attributes in the expression must
     * be separated by commas. <p>If no attribute names are specified, then
     * all attributes will be returned. If any of the requested attributes
     * are not found, they will not appear in the result. <p>For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     * Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <note><p><i>ProjectionExpression</i> replaces the legacy
     * <i>AttributesToGet</i> parameter.</note>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param projectionExpression A string that identifies one or more attributes to retrieve from the
     *         specified table or index. These attributes can include scalars, sets,
     *         or elements of a JSON document. The attributes in the expression must
     *         be separated by commas. <p>If no attribute names are specified, then
     *         all attributes will be returned. If any of the requested attributes
     *         are not found, they will not appear in the result. <p>For more
     *         information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     *         Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *         <note><p><i>ProjectionExpression</i> replaces the legacy
     *         <i>AttributesToGet</i> parameter.</note>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withProjectionExpression(String projectionExpression) {
        this.projectionExpression = projectionExpression;
        return this;
    }

    /**
     * A string that contains conditions that DynamoDB applies after the
     * <i>Scan</i> operation, but before the data is returned to you. Items
     * that do not satisfy the <i>FilterExpression</i> criteria are not
     * returned. <note> <p>A <i>FilterExpression</i> is applied after the
     * items have already been read; the process of filtering does not
     * consume any additional read capacity units.</note> <p>For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     * Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <note><p><i>FilterExpression</i> replaces the legacy <i>ScanFilter</i>
     * and <i>ConditionalOperator</i> parameters.</note>
     *
     * @return A string that contains conditions that DynamoDB applies after the
     *         <i>Scan</i> operation, but before the data is returned to you. Items
     *         that do not satisfy the <i>FilterExpression</i> criteria are not
     *         returned. <note> <p>A <i>FilterExpression</i> is applied after the
     *         items have already been read; the process of filtering does not
     *         consume any additional read capacity units.</note> <p>For more
     *         information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     *         Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *         <note><p><i>FilterExpression</i> replaces the legacy <i>ScanFilter</i>
     *         and <i>ConditionalOperator</i> parameters.</note>
     */
    public String getFilterExpression() {
        return filterExpression;
    }
    
    /**
     * A string that contains conditions that DynamoDB applies after the
     * <i>Scan</i> operation, but before the data is returned to you. Items
     * that do not satisfy the <i>FilterExpression</i> criteria are not
     * returned. <note> <p>A <i>FilterExpression</i> is applied after the
     * items have already been read; the process of filtering does not
     * consume any additional read capacity units.</note> <p>For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     * Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <note><p><i>FilterExpression</i> replaces the legacy <i>ScanFilter</i>
     * and <i>ConditionalOperator</i> parameters.</note>
     *
     * @param filterExpression A string that contains conditions that DynamoDB applies after the
     *         <i>Scan</i> operation, but before the data is returned to you. Items
     *         that do not satisfy the <i>FilterExpression</i> criteria are not
     *         returned. <note> <p>A <i>FilterExpression</i> is applied after the
     *         items have already been read; the process of filtering does not
     *         consume any additional read capacity units.</note> <p>For more
     *         information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     *         Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *         <note><p><i>FilterExpression</i> replaces the legacy <i>ScanFilter</i>
     *         and <i>ConditionalOperator</i> parameters.</note>
     */
    public void setFilterExpression(String filterExpression) {
        this.filterExpression = filterExpression;
    }
    
    /**
     * A string that contains conditions that DynamoDB applies after the
     * <i>Scan</i> operation, but before the data is returned to you. Items
     * that do not satisfy the <i>FilterExpression</i> criteria are not
     * returned. <note> <p>A <i>FilterExpression</i> is applied after the
     * items have already been read; the process of filtering does not
     * consume any additional read capacity units.</note> <p>For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     * Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <note><p><i>FilterExpression</i> replaces the legacy <i>ScanFilter</i>
     * and <i>ConditionalOperator</i> parameters.</note>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param filterExpression A string that contains conditions that DynamoDB applies after the
     *         <i>Scan</i> operation, but before the data is returned to you. Items
     *         that do not satisfy the <i>FilterExpression</i> criteria are not
     *         returned. <note> <p>A <i>FilterExpression</i> is applied after the
     *         items have already been read; the process of filtering does not
     *         consume any additional read capacity units.</note> <p>For more
     *         information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     *         Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *         <note><p><i>FilterExpression</i> replaces the legacy <i>ScanFilter</i>
     *         and <i>ConditionalOperator</i> parameters.</note>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withFilterExpression(String filterExpression) {
        this.filterExpression = filterExpression;
        return this;
    }

    /**
     * One or more substitution tokens for attribute names in an expression.
     * The following are some use cases for using
     * <i>ExpressionAttributeNames</i>: <ul> <li> <p>To access an attribute
     * whose name conflicts with a DynamoDB reserved word. </li> <li> <p>To
     * create a placeholder for repeating occurrences of an attribute name in
     * an expression. </li> <li> <p>To prevent special characters in an
     * attribute name from being misinterpreted in an expression. </li> </ul>
     * <p>Use the <b>#</b> character in an expression to dereference an
     * attribute name. For example, consider the following attribute name:
     * <ul><li><p><code>Percentile</code></li></ul> <p>The name of this
     * attribute conflicts with a reserved word, so it cannot be used
     * directly in an expression. (For the complete list of reserved words,
     * see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     * Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work
     * around this, you could specify the following for
     * <i>ExpressionAttributeNames</i>:
     * <ul><li><p><code>{"#P":"Percentile"}</code></li></ul> <p>You could
     * then use this substitution in an expression, as in this example:
     * <ul><li><p><code>#P = :val</code></li></ul> <note><p>Tokens that begin
     * with the <b>:</b> character are <i>expression attribute values</i>,
     * which are placeholders for the actual value at runtime.</note> <p>For
     * more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     * Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *
     * @return One or more substitution tokens for attribute names in an expression.
     *         The following are some use cases for using
     *         <i>ExpressionAttributeNames</i>: <ul> <li> <p>To access an attribute
     *         whose name conflicts with a DynamoDB reserved word. </li> <li> <p>To
     *         create a placeholder for repeating occurrences of an attribute name in
     *         an expression. </li> <li> <p>To prevent special characters in an
     *         attribute name from being misinterpreted in an expression. </li> </ul>
     *         <p>Use the <b>#</b> character in an expression to dereference an
     *         attribute name. For example, consider the following attribute name:
     *         <ul><li><p><code>Percentile</code></li></ul> <p>The name of this
     *         attribute conflicts with a reserved word, so it cannot be used
     *         directly in an expression. (For the complete list of reserved words,
     *         see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *         Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work
     *         around this, you could specify the following for
     *         <i>ExpressionAttributeNames</i>:
     *         <ul><li><p><code>{"#P":"Percentile"}</code></li></ul> <p>You could
     *         then use this substitution in an expression, as in this example:
     *         <ul><li><p><code>#P = :val</code></li></ul> <note><p>Tokens that begin
     *         with the <b>:</b> character are <i>expression attribute values</i>,
     *         which are placeholders for the actual value at runtime.</note> <p>For
     *         more information on expression attribute names, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     *         Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    public java.util.Map<String,String> getExpressionAttributeNames() {
        
        return expressionAttributeNames;
    }
    
    /**
     * One or more substitution tokens for attribute names in an expression.
     * The following are some use cases for using
     * <i>ExpressionAttributeNames</i>: <ul> <li> <p>To access an attribute
     * whose name conflicts with a DynamoDB reserved word. </li> <li> <p>To
     * create a placeholder for repeating occurrences of an attribute name in
     * an expression. </li> <li> <p>To prevent special characters in an
     * attribute name from being misinterpreted in an expression. </li> </ul>
     * <p>Use the <b>#</b> character in an expression to dereference an
     * attribute name. For example, consider the following attribute name:
     * <ul><li><p><code>Percentile</code></li></ul> <p>The name of this
     * attribute conflicts with a reserved word, so it cannot be used
     * directly in an expression. (For the complete list of reserved words,
     * see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     * Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work
     * around this, you could specify the following for
     * <i>ExpressionAttributeNames</i>:
     * <ul><li><p><code>{"#P":"Percentile"}</code></li></ul> <p>You could
     * then use this substitution in an expression, as in this example:
     * <ul><li><p><code>#P = :val</code></li></ul> <note><p>Tokens that begin
     * with the <b>:</b> character are <i>expression attribute values</i>,
     * which are placeholders for the actual value at runtime.</note> <p>For
     * more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     * Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *
     * @param expressionAttributeNames One or more substitution tokens for attribute names in an expression.
     *         The following are some use cases for using
     *         <i>ExpressionAttributeNames</i>: <ul> <li> <p>To access an attribute
     *         whose name conflicts with a DynamoDB reserved word. </li> <li> <p>To
     *         create a placeholder for repeating occurrences of an attribute name in
     *         an expression. </li> <li> <p>To prevent special characters in an
     *         attribute name from being misinterpreted in an expression. </li> </ul>
     *         <p>Use the <b>#</b> character in an expression to dereference an
     *         attribute name. For example, consider the following attribute name:
     *         <ul><li><p><code>Percentile</code></li></ul> <p>The name of this
     *         attribute conflicts with a reserved word, so it cannot be used
     *         directly in an expression. (For the complete list of reserved words,
     *         see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *         Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work
     *         around this, you could specify the following for
     *         <i>ExpressionAttributeNames</i>:
     *         <ul><li><p><code>{"#P":"Percentile"}</code></li></ul> <p>You could
     *         then use this substitution in an expression, as in this example:
     *         <ul><li><p><code>#P = :val</code></li></ul> <note><p>Tokens that begin
     *         with the <b>:</b> character are <i>expression attribute values</i>,
     *         which are placeholders for the actual value at runtime.</note> <p>For
     *         more information on expression attribute names, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     *         Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    public void setExpressionAttributeNames(java.util.Map<String,String> expressionAttributeNames) {
        this.expressionAttributeNames = expressionAttributeNames;
    }
    
    /**
     * One or more substitution tokens for attribute names in an expression.
     * The following are some use cases for using
     * <i>ExpressionAttributeNames</i>: <ul> <li> <p>To access an attribute
     * whose name conflicts with a DynamoDB reserved word. </li> <li> <p>To
     * create a placeholder for repeating occurrences of an attribute name in
     * an expression. </li> <li> <p>To prevent special characters in an
     * attribute name from being misinterpreted in an expression. </li> </ul>
     * <p>Use the <b>#</b> character in an expression to dereference an
     * attribute name. For example, consider the following attribute name:
     * <ul><li><p><code>Percentile</code></li></ul> <p>The name of this
     * attribute conflicts with a reserved word, so it cannot be used
     * directly in an expression. (For the complete list of reserved words,
     * see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     * Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work
     * around this, you could specify the following for
     * <i>ExpressionAttributeNames</i>:
     * <ul><li><p><code>{"#P":"Percentile"}</code></li></ul> <p>You could
     * then use this substitution in an expression, as in this example:
     * <ul><li><p><code>#P = :val</code></li></ul> <note><p>Tokens that begin
     * with the <b>:</b> character are <i>expression attribute values</i>,
     * which are placeholders for the actual value at runtime.</note> <p>For
     * more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     * Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param expressionAttributeNames One or more substitution tokens for attribute names in an expression.
     *         The following are some use cases for using
     *         <i>ExpressionAttributeNames</i>: <ul> <li> <p>To access an attribute
     *         whose name conflicts with a DynamoDB reserved word. </li> <li> <p>To
     *         create a placeholder for repeating occurrences of an attribute name in
     *         an expression. </li> <li> <p>To prevent special characters in an
     *         attribute name from being misinterpreted in an expression. </li> </ul>
     *         <p>Use the <b>#</b> character in an expression to dereference an
     *         attribute name. For example, consider the following attribute name:
     *         <ul><li><p><code>Percentile</code></li></ul> <p>The name of this
     *         attribute conflicts with a reserved word, so it cannot be used
     *         directly in an expression. (For the complete list of reserved words,
     *         see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *         Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work
     *         around this, you could specify the following for
     *         <i>ExpressionAttributeNames</i>:
     *         <ul><li><p><code>{"#P":"Percentile"}</code></li></ul> <p>You could
     *         then use this substitution in an expression, as in this example:
     *         <ul><li><p><code>#P = :val</code></li></ul> <note><p>Tokens that begin
     *         with the <b>:</b> character are <i>expression attribute values</i>,
     *         which are placeholders for the actual value at runtime.</note> <p>For
     *         more information on expression attribute names, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     *         Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withExpressionAttributeNames(java.util.Map<String,String> expressionAttributeNames) {
        setExpressionAttributeNames(expressionAttributeNames);
        return this;
    }

    /**
     * One or more substitution tokens for attribute names in an expression.
     * The following are some use cases for using
     * <i>ExpressionAttributeNames</i>: <ul> <li> <p>To access an attribute
     * whose name conflicts with a DynamoDB reserved word. </li> <li> <p>To
     * create a placeholder for repeating occurrences of an attribute name in
     * an expression. </li> <li> <p>To prevent special characters in an
     * attribute name from being misinterpreted in an expression. </li> </ul>
     * <p>Use the <b>#</b> character in an expression to dereference an
     * attribute name. For example, consider the following attribute name:
     * <ul><li><p><code>Percentile</code></li></ul> <p>The name of this
     * attribute conflicts with a reserved word, so it cannot be used
     * directly in an expression. (For the complete list of reserved words,
     * see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     * Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work
     * around this, you could specify the following for
     * <i>ExpressionAttributeNames</i>:
     * <ul><li><p><code>{"#P":"Percentile"}</code></li></ul> <p>You could
     * then use this substitution in an expression, as in this example:
     * <ul><li><p><code>#P = :val</code></li></ul> <note><p>Tokens that begin
     * with the <b>:</b> character are <i>expression attribute values</i>,
     * which are placeholders for the actual value at runtime.</note> <p>For
     * more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html">Accessing
     * Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * The method adds a new key-value pair into ExpressionAttributeNames
     * parameter, and returns a reference to this object so that method calls
     * can be chained together.
     *
     * @param key The key of the entry to be added into ExpressionAttributeNames.
     * @param value The corresponding value of the entry to be added into ExpressionAttributeNames.
     */
    public ScanRequest addExpressionAttributeNamesEntry(String key, String value) {
        if (null == this.expressionAttributeNames) {
            this.expressionAttributeNames = new java.util.HashMap<String,String>();
        }
        if (this.expressionAttributeNames.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.expressionAttributeNames.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ExpressionAttributeNames.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public ScanRequest clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }
    
    /**
     * One or more values that can be substituted in an expression. <p>Use
     * the <b>:</b> (colon) character in an expression to dereference an
     * attribute value. For example, suppose that you wanted to check whether
     * the value of the <i>ProductStatus</i> attribute was one of the
     * following: <p><code>Available | Backordered | Discontinued</code>
     * <p>You would first need to specify <i>ExpressionAttributeValues</i> as
     * follows: <p><code>{ ":avail":{"S":"Available"},
     * ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     * <p>You could then use these values in an expression, such as this:
     * <p><code>ProductStatus IN (:avail, :back, :disc)</code> <p>For more
     * information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html">Specifying
     * Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *
     * @return One or more values that can be substituted in an expression. <p>Use
     *         the <b>:</b> (colon) character in an expression to dereference an
     *         attribute value. For example, suppose that you wanted to check whether
     *         the value of the <i>ProductStatus</i> attribute was one of the
     *         following: <p><code>Available | Backordered | Discontinued</code>
     *         <p>You would first need to specify <i>ExpressionAttributeValues</i> as
     *         follows: <p><code>{ ":avail":{"S":"Available"},
     *         ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     *         <p>You could then use these values in an expression, such as this:
     *         <p><code>ProductStatus IN (:avail, :back, :disc)</code> <p>For more
     *         information on expression attribute values, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html">Specifying
     *         Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    public java.util.Map<String,AttributeValue> getExpressionAttributeValues() {
        
        return expressionAttributeValues;
    }
    
    /**
     * One or more values that can be substituted in an expression. <p>Use
     * the <b>:</b> (colon) character in an expression to dereference an
     * attribute value. For example, suppose that you wanted to check whether
     * the value of the <i>ProductStatus</i> attribute was one of the
     * following: <p><code>Available | Backordered | Discontinued</code>
     * <p>You would first need to specify <i>ExpressionAttributeValues</i> as
     * follows: <p><code>{ ":avail":{"S":"Available"},
     * ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     * <p>You could then use these values in an expression, such as this:
     * <p><code>ProductStatus IN (:avail, :back, :disc)</code> <p>For more
     * information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html">Specifying
     * Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *
     * @param expressionAttributeValues One or more values that can be substituted in an expression. <p>Use
     *         the <b>:</b> (colon) character in an expression to dereference an
     *         attribute value. For example, suppose that you wanted to check whether
     *         the value of the <i>ProductStatus</i> attribute was one of the
     *         following: <p><code>Available | Backordered | Discontinued</code>
     *         <p>You would first need to specify <i>ExpressionAttributeValues</i> as
     *         follows: <p><code>{ ":avail":{"S":"Available"},
     *         ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     *         <p>You could then use these values in an expression, such as this:
     *         <p><code>ProductStatus IN (:avail, :back, :disc)</code> <p>For more
     *         information on expression attribute values, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html">Specifying
     *         Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    public void setExpressionAttributeValues(java.util.Map<String,AttributeValue> expressionAttributeValues) {
        this.expressionAttributeValues = expressionAttributeValues;
    }
    
    /**
     * One or more values that can be substituted in an expression. <p>Use
     * the <b>:</b> (colon) character in an expression to dereference an
     * attribute value. For example, suppose that you wanted to check whether
     * the value of the <i>ProductStatus</i> attribute was one of the
     * following: <p><code>Available | Backordered | Discontinued</code>
     * <p>You would first need to specify <i>ExpressionAttributeValues</i> as
     * follows: <p><code>{ ":avail":{"S":"Available"},
     * ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     * <p>You could then use these values in an expression, such as this:
     * <p><code>ProductStatus IN (:avail, :back, :disc)</code> <p>For more
     * information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html">Specifying
     * Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param expressionAttributeValues One or more values that can be substituted in an expression. <p>Use
     *         the <b>:</b> (colon) character in an expression to dereference an
     *         attribute value. For example, suppose that you wanted to check whether
     *         the value of the <i>ProductStatus</i> attribute was one of the
     *         following: <p><code>Available | Backordered | Discontinued</code>
     *         <p>You would first need to specify <i>ExpressionAttributeValues</i> as
     *         follows: <p><code>{ ":avail":{"S":"Available"},
     *         ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     *         <p>You could then use these values in an expression, such as this:
     *         <p><code>ProductStatus IN (:avail, :back, :disc)</code> <p>For more
     *         information on expression attribute values, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html">Specifying
     *         Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withExpressionAttributeValues(java.util.Map<String,AttributeValue> expressionAttributeValues) {
        setExpressionAttributeValues(expressionAttributeValues);
        return this;
    }

    /**
     * One or more values that can be substituted in an expression. <p>Use
     * the <b>:</b> (colon) character in an expression to dereference an
     * attribute value. For example, suppose that you wanted to check whether
     * the value of the <i>ProductStatus</i> attribute was one of the
     * following: <p><code>Available | Backordered | Discontinued</code>
     * <p>You would first need to specify <i>ExpressionAttributeValues</i> as
     * follows: <p><code>{ ":avail":{"S":"Available"},
     * ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     * <p>You could then use these values in an expression, such as this:
     * <p><code>ProductStatus IN (:avail, :back, :disc)</code> <p>For more
     * information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html">Specifying
     * Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * The method adds a new key-value pair into ExpressionAttributeValues
     * parameter, and returns a reference to this object so that method calls
     * can be chained together.
     *
     * @param key The key of the entry to be added into ExpressionAttributeValues.
     * @param value The corresponding value of the entry to be added into ExpressionAttributeValues.
     */
    public ScanRequest addExpressionAttributeValuesEntry(String key, AttributeValue value) {
        if (null == this.expressionAttributeValues) {
            this.expressionAttributeValues = new java.util.HashMap<String,AttributeValue>();
        }
        if (this.expressionAttributeValues.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.expressionAttributeValues.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ExpressionAttributeValues.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public ScanRequest clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }
    
    /**
     * A Boolean value that determines the read consistency model during the
     * scan: <ul> <li> <p>If <i>ConsistentRead</i> is <code>false</code>,
     * then the data returned from <i>Scan</i> might not contain the results
     * from other recently completed write operations (PutItem, UpdateItem or
     * DeleteItem). </li> <li> <p>If <i>ConsistentRead</i> is
     * <code>true</code>, then all of the write operations that completed
     * before the <i>Scan</i> began are guaranteed to be contained in the
     * <i>Scan</i> response. </li> </ul> <p>The default setting for
     * <i>ConsistentRead</i> is <code>false</code>. <p>The
     * <i>ConsistentRead</i> parameter is not supported on global secondary
     * indexes. If you scan a global secondary index with
     * <i>ConsistentRead</i> set to true, you will receive a
     * <i>ValidationException</i>.
     *
     * @return A Boolean value that determines the read consistency model during the
     *         scan: <ul> <li> <p>If <i>ConsistentRead</i> is <code>false</code>,
     *         then the data returned from <i>Scan</i> might not contain the results
     *         from other recently completed write operations (PutItem, UpdateItem or
     *         DeleteItem). </li> <li> <p>If <i>ConsistentRead</i> is
     *         <code>true</code>, then all of the write operations that completed
     *         before the <i>Scan</i> began are guaranteed to be contained in the
     *         <i>Scan</i> response. </li> </ul> <p>The default setting for
     *         <i>ConsistentRead</i> is <code>false</code>. <p>The
     *         <i>ConsistentRead</i> parameter is not supported on global secondary
     *         indexes. If you scan a global secondary index with
     *         <i>ConsistentRead</i> set to true, you will receive a
     *         <i>ValidationException</i>.
     */
    public Boolean isConsistentRead() {
        return consistentRead;
    }
    
    /**
     * A Boolean value that determines the read consistency model during the
     * scan: <ul> <li> <p>If <i>ConsistentRead</i> is <code>false</code>,
     * then the data returned from <i>Scan</i> might not contain the results
     * from other recently completed write operations (PutItem, UpdateItem or
     * DeleteItem). </li> <li> <p>If <i>ConsistentRead</i> is
     * <code>true</code>, then all of the write operations that completed
     * before the <i>Scan</i> began are guaranteed to be contained in the
     * <i>Scan</i> response. </li> </ul> <p>The default setting for
     * <i>ConsistentRead</i> is <code>false</code>. <p>The
     * <i>ConsistentRead</i> parameter is not supported on global secondary
     * indexes. If you scan a global secondary index with
     * <i>ConsistentRead</i> set to true, you will receive a
     * <i>ValidationException</i>.
     *
     * @param consistentRead A Boolean value that determines the read consistency model during the
     *         scan: <ul> <li> <p>If <i>ConsistentRead</i> is <code>false</code>,
     *         then the data returned from <i>Scan</i> might not contain the results
     *         from other recently completed write operations (PutItem, UpdateItem or
     *         DeleteItem). </li> <li> <p>If <i>ConsistentRead</i> is
     *         <code>true</code>, then all of the write operations that completed
     *         before the <i>Scan</i> began are guaranteed to be contained in the
     *         <i>Scan</i> response. </li> </ul> <p>The default setting for
     *         <i>ConsistentRead</i> is <code>false</code>. <p>The
     *         <i>ConsistentRead</i> parameter is not supported on global secondary
     *         indexes. If you scan a global secondary index with
     *         <i>ConsistentRead</i> set to true, you will receive a
     *         <i>ValidationException</i>.
     */
    public void setConsistentRead(Boolean consistentRead) {
        this.consistentRead = consistentRead;
    }
    
    /**
     * A Boolean value that determines the read consistency model during the
     * scan: <ul> <li> <p>If <i>ConsistentRead</i> is <code>false</code>,
     * then the data returned from <i>Scan</i> might not contain the results
     * from other recently completed write operations (PutItem, UpdateItem or
     * DeleteItem). </li> <li> <p>If <i>ConsistentRead</i> is
     * <code>true</code>, then all of the write operations that completed
     * before the <i>Scan</i> began are guaranteed to be contained in the
     * <i>Scan</i> response. </li> </ul> <p>The default setting for
     * <i>ConsistentRead</i> is <code>false</code>. <p>The
     * <i>ConsistentRead</i> parameter is not supported on global secondary
     * indexes. If you scan a global secondary index with
     * <i>ConsistentRead</i> set to true, you will receive a
     * <i>ValidationException</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param consistentRead A Boolean value that determines the read consistency model during the
     *         scan: <ul> <li> <p>If <i>ConsistentRead</i> is <code>false</code>,
     *         then the data returned from <i>Scan</i> might not contain the results
     *         from other recently completed write operations (PutItem, UpdateItem or
     *         DeleteItem). </li> <li> <p>If <i>ConsistentRead</i> is
     *         <code>true</code>, then all of the write operations that completed
     *         before the <i>Scan</i> began are guaranteed to be contained in the
     *         <i>Scan</i> response. </li> </ul> <p>The default setting for
     *         <i>ConsistentRead</i> is <code>false</code>. <p>The
     *         <i>ConsistentRead</i> parameter is not supported on global secondary
     *         indexes. If you scan a global secondary index with
     *         <i>ConsistentRead</i> set to true, you will receive a
     *         <i>ValidationException</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ScanRequest withConsistentRead(Boolean consistentRead) {
        this.consistentRead = consistentRead;
        return this;
    }

    /**
     * A Boolean value that determines the read consistency model during the
     * scan: <ul> <li> <p>If <i>ConsistentRead</i> is <code>false</code>,
     * then the data returned from <i>Scan</i> might not contain the results
     * from other recently completed write operations (PutItem, UpdateItem or
     * DeleteItem). </li> <li> <p>If <i>ConsistentRead</i> is
     * <code>true</code>, then all of the write operations that completed
     * before the <i>Scan</i> began are guaranteed to be contained in the
     * <i>Scan</i> response. </li> </ul> <p>The default setting for
     * <i>ConsistentRead</i> is <code>false</code>. <p>The
     * <i>ConsistentRead</i> parameter is not supported on global secondary
     * indexes. If you scan a global secondary index with
     * <i>ConsistentRead</i> set to true, you will receive a
     * <i>ValidationException</i>.
     *
     * @return A Boolean value that determines the read consistency model during the
     *         scan: <ul> <li> <p>If <i>ConsistentRead</i> is <code>false</code>,
     *         then the data returned from <i>Scan</i> might not contain the results
     *         from other recently completed write operations (PutItem, UpdateItem or
     *         DeleteItem). </li> <li> <p>If <i>ConsistentRead</i> is
     *         <code>true</code>, then all of the write operations that completed
     *         before the <i>Scan</i> began are guaranteed to be contained in the
     *         <i>Scan</i> response. </li> </ul> <p>The default setting for
     *         <i>ConsistentRead</i> is <code>false</code>. <p>The
     *         <i>ConsistentRead</i> parameter is not supported on global secondary
     *         indexes. If you scan a global secondary index with
     *         <i>ConsistentRead</i> set to true, you will receive a
     *         <i>ValidationException</i>.
     */
    public Boolean getConsistentRead() {
        return consistentRead;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTableName() != null) sb.append("TableName: " + getTableName() + ",");
        if (getIndexName() != null) sb.append("IndexName: " + getIndexName() + ",");
        if (getAttributesToGet() != null) sb.append("AttributesToGet: " + getAttributesToGet() + ",");
        if (getLimit() != null) sb.append("Limit: " + getLimit() + ",");
        if (getSelect() != null) sb.append("Select: " + getSelect() + ",");
        if (getScanFilter() != null) sb.append("ScanFilter: " + getScanFilter() + ",");
        if (getConditionalOperator() != null) sb.append("ConditionalOperator: " + getConditionalOperator() + ",");
        if (getExclusiveStartKey() != null) sb.append("ExclusiveStartKey: " + getExclusiveStartKey() + ",");
        if (getReturnConsumedCapacity() != null) sb.append("ReturnConsumedCapacity: " + getReturnConsumedCapacity() + ",");
        if (getTotalSegments() != null) sb.append("TotalSegments: " + getTotalSegments() + ",");
        if (getSegment() != null) sb.append("Segment: " + getSegment() + ",");
        if (getProjectionExpression() != null) sb.append("ProjectionExpression: " + getProjectionExpression() + ",");
        if (getFilterExpression() != null) sb.append("FilterExpression: " + getFilterExpression() + ",");
        if (getExpressionAttributeNames() != null) sb.append("ExpressionAttributeNames: " + getExpressionAttributeNames() + ",");
        if (getExpressionAttributeValues() != null) sb.append("ExpressionAttributeValues: " + getExpressionAttributeValues() + ",");
        if (isConsistentRead() != null) sb.append("ConsistentRead: " + isConsistentRead() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getTableName() == null) ? 0 : getTableName().hashCode()); 
        hashCode = prime * hashCode + ((getIndexName() == null) ? 0 : getIndexName().hashCode()); 
        hashCode = prime * hashCode + ((getAttributesToGet() == null) ? 0 : getAttributesToGet().hashCode()); 
        hashCode = prime * hashCode + ((getLimit() == null) ? 0 : getLimit().hashCode()); 
        hashCode = prime * hashCode + ((getSelect() == null) ? 0 : getSelect().hashCode()); 
        hashCode = prime * hashCode + ((getScanFilter() == null) ? 0 : getScanFilter().hashCode()); 
        hashCode = prime * hashCode + ((getConditionalOperator() == null) ? 0 : getConditionalOperator().hashCode()); 
        hashCode = prime * hashCode + ((getExclusiveStartKey() == null) ? 0 : getExclusiveStartKey().hashCode()); 
        hashCode = prime * hashCode + ((getReturnConsumedCapacity() == null) ? 0 : getReturnConsumedCapacity().hashCode()); 
        hashCode = prime * hashCode + ((getTotalSegments() == null) ? 0 : getTotalSegments().hashCode()); 
        hashCode = prime * hashCode + ((getSegment() == null) ? 0 : getSegment().hashCode()); 
        hashCode = prime * hashCode + ((getProjectionExpression() == null) ? 0 : getProjectionExpression().hashCode()); 
        hashCode = prime * hashCode + ((getFilterExpression() == null) ? 0 : getFilterExpression().hashCode()); 
        hashCode = prime * hashCode + ((getExpressionAttributeNames() == null) ? 0 : getExpressionAttributeNames().hashCode()); 
        hashCode = prime * hashCode + ((getExpressionAttributeValues() == null) ? 0 : getExpressionAttributeValues().hashCode()); 
        hashCode = prime * hashCode + ((isConsistentRead() == null) ? 0 : isConsistentRead().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof ScanRequest == false) return false;
        ScanRequest other = (ScanRequest)obj;
        
        if (other.getTableName() == null ^ this.getTableName() == null) return false;
        if (other.getTableName() != null && other.getTableName().equals(this.getTableName()) == false) return false; 
        if (other.getIndexName() == null ^ this.getIndexName() == null) return false;
        if (other.getIndexName() != null && other.getIndexName().equals(this.getIndexName()) == false) return false; 
        if (other.getAttributesToGet() == null ^ this.getAttributesToGet() == null) return false;
        if (other.getAttributesToGet() != null && other.getAttributesToGet().equals(this.getAttributesToGet()) == false) return false; 
        if (other.getLimit() == null ^ this.getLimit() == null) return false;
        if (other.getLimit() != null && other.getLimit().equals(this.getLimit()) == false) return false; 
        if (other.getSelect() == null ^ this.getSelect() == null) return false;
        if (other.getSelect() != null && other.getSelect().equals(this.getSelect()) == false) return false; 
        if (other.getScanFilter() == null ^ this.getScanFilter() == null) return false;
        if (other.getScanFilter() != null && other.getScanFilter().equals(this.getScanFilter()) == false) return false; 
        if (other.getConditionalOperator() == null ^ this.getConditionalOperator() == null) return false;
        if (other.getConditionalOperator() != null && other.getConditionalOperator().equals(this.getConditionalOperator()) == false) return false; 
        if (other.getExclusiveStartKey() == null ^ this.getExclusiveStartKey() == null) return false;
        if (other.getExclusiveStartKey() != null && other.getExclusiveStartKey().equals(this.getExclusiveStartKey()) == false) return false; 
        if (other.getReturnConsumedCapacity() == null ^ this.getReturnConsumedCapacity() == null) return false;
        if (other.getReturnConsumedCapacity() != null && other.getReturnConsumedCapacity().equals(this.getReturnConsumedCapacity()) == false) return false; 
        if (other.getTotalSegments() == null ^ this.getTotalSegments() == null) return false;
        if (other.getTotalSegments() != null && other.getTotalSegments().equals(this.getTotalSegments()) == false) return false; 
        if (other.getSegment() == null ^ this.getSegment() == null) return false;
        if (other.getSegment() != null && other.getSegment().equals(this.getSegment()) == false) return false; 
        if (other.getProjectionExpression() == null ^ this.getProjectionExpression() == null) return false;
        if (other.getProjectionExpression() != null && other.getProjectionExpression().equals(this.getProjectionExpression()) == false) return false; 
        if (other.getFilterExpression() == null ^ this.getFilterExpression() == null) return false;
        if (other.getFilterExpression() != null && other.getFilterExpression().equals(this.getFilterExpression()) == false) return false; 
        if (other.getExpressionAttributeNames() == null ^ this.getExpressionAttributeNames() == null) return false;
        if (other.getExpressionAttributeNames() != null && other.getExpressionAttributeNames().equals(this.getExpressionAttributeNames()) == false) return false; 
        if (other.getExpressionAttributeValues() == null ^ this.getExpressionAttributeValues() == null) return false;
        if (other.getExpressionAttributeValues() != null && other.getExpressionAttributeValues().equals(this.getExpressionAttributeValues()) == false) return false; 
        if (other.isConsistentRead() == null ^ this.isConsistentRead() == null) return false;
        if (other.isConsistentRead() != null && other.isConsistentRead().equals(this.isConsistentRead()) == false) return false; 
        return true;
    }
    
}
    