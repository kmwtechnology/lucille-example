package com.lucille.example.connector;

import com.kmwllc.lucille.connector.AbstractConnector;
import com.kmwllc.lucille.core.*;
import com.typesafe.config.Config;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Connector implementation that creates x number documents with randomly generated field values.
 * <br>
 * Config Parameters -
 * <br>
 * numDocs (String) : Number of docs that you want to produce
 * fieldNames (List&lt;String&gt;) : List of fields to create
 */
public class RandomDocConnector extends AbstractConnector {

  private static final Logger log = LoggerFactory.getLogger(RandomDocConnector.class);

  private int numDocs;
  private List<String> fieldNames;

  private Random rand = new Random();


  public RandomDocConnector(Config config) throws ConnectorException {
    super(config);
    if ( config.getInt("numDocs") > 1000000) {
      throw new ConnectorException("The number of documents (numDocs) cannot be grater than 1000000.");
    }
    numDocs = config.getInt("numDocs");
    fieldNames = config.getStringList("fieldNames");
  }

  @Override
  public void execute(Publisher publisher) throws ConnectorException {
    int randBound = this.numDocs * 1000;

    log.info("Generating {} documents with random values.", this.numDocs);
    for (int i = 0; i < this.numDocs; i++) {
      Document doc = Document.create(Integer.toString(i));
      for (String field : this.fieldNames) {
        doc.setField(field, this.rand.nextInt(randBound));
      }
      try {
        publisher.publish(doc);
      } catch (Exception e) {
        throw new ConnectorException("Exception caught during connector execution", e);
      }
    }
  }
}
