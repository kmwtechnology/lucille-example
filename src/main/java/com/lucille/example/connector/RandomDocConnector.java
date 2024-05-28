package com.lucille.example.connector;

import com.kmwllc.lucille.connector.AbstractConnector;
import com.kmwllc.lucille.core.*;
import com.typesafe.config.Config;
import java.util.*;

/**
 *  Connector implementation that creates x number documents with randomly generated field values.
 * <br>
 * Config Parameters -
 * <br>
 * numDocs (String) : Number of docs that you want to produce
 * fieldNames (List&lt;String&gt;) : List of fields to create
 */
public class RandomDocConnector extends AbstractConnector {

  private int numDocs;
  private List<String> fieldNames;

  private Random rand = new Random();
  private int MAX = Integer.MAX_VALUE;


  public RandomDocConnector(Config config) {
    super(config);
    numDocs = config.getInt("numDocs");
    fieldNames = config.getStringList("fieldNames");
  }

  @Override
  public void preExecute(String runId) {
    // calculate maximum bound for random number generator
    this.MAX = this.numDocs * 1000;
  }

  @Override
  public void execute(Publisher publisher) throws ConnectorException {

    for (int i = 0; i < this.numDocs; i++) {
      Document doc = Document.create(Integer.toString(i));
      for (String field : this.fieldNames) {
        doc.setField(field, this.rand.nextInt(this.MAX));
      }
      try {
        publisher.publish(doc);
      } catch (Exception e) {
        throw new ConnectorException("Exception caught during connector execution", e);
      }
    }
  }

  @Override
  public void postExecute(String runId) throws ConnectorException {
    super.postExecute(runId);
  }

  @Override
  public void close() throws ConnectorException {
    super.close();
  }
}
