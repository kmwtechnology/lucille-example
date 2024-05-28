package com.lucille.example.connector;

import static org.junit.Assert.assertEquals;
import com.kmwllc.lucille.core.Connector;
import com.kmwllc.lucille.core.Document;
import com.kmwllc.lucille.core.Publisher;
import com.kmwllc.lucille.core.PublisherImpl;
import com.kmwllc.lucille.message.TestMessenger;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.util.List;
import org.junit.Test;

public class RandomDocConnectorTest {

  @Test
  public void testExecute() throws Exception {
    Config config = ConfigFactory.load("RandomDocConnector/config.conf");

    TestMessenger messenger = new TestMessenger();
    Publisher publisher = new PublisherImpl(config, messenger, "run", "pipeline1");
    Connector connector = new RandomDocConnector(config);
    connector.execute(publisher);

    List<Document> docs = messenger.getDocsSentForProcessing();
    // ensure doc count is correct
    assertEquals(50, docs.size());
    // ensure all expected fields are there ["randTime", "randNum"]
    try {
      docs.forEach(document -> document.validateFieldNames("randTime", "randNum"));
      assert true;
    } catch (IllegalArgumentException e) {
      assert false;
      throw new IllegalArgumentException(e);
    }
  }

}
