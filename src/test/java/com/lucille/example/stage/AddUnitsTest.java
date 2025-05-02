package com.lucille.example.stage;

import static org.junit.Assert.assertEquals;
import com.kmwllc.lucille.core.Document;
import com.kmwllc.lucille.core.Stage;
import com.kmwllc.lucille.core.StageException;
import com.kmwllc.lucille.stage.StageFactory;
import org.junit.Test;

public class AddUnitsTest {

  private final StageFactory factory = StageFactory.of(AddUnitsStage.class);

  @Test
  public void testAddUnitBefore() throws StageException {
    Stage stage = factory.get("AddUnitsStage/config-before.conf");

    Document doc1 = Document.create("doc1");
    doc1.setField("item", "stapler");
    doc1.setField("price", "10.00");
    stage.processDocument(doc1);
    assertEquals("$10.00", doc1.getString("price"));

    Document doc2 = Document.create("doc2");
    doc2.setField("item", "monitor");
    doc2.setField("price", "323");
    stage.processDocument(doc2);
    assertEquals("$323", doc2.getString("price"));

    Document doc3 = Document.create("doc3");
    doc3.setField("item", "phone");
    stage.processDocument(doc3);
    assertEquals(null, doc3.getString("price"));
  }

  @Test
  public void testAddUnitAfter() throws StageException {
    Stage stage = factory.get("AddUnitsStage/config-after.conf");

    Document doc1 = Document.create("doc1");
    doc1.setField("race", "100m dash");
    doc1.setField("time", "9580");
    stage.processDocument(doc1);
    assertEquals("9580ms", doc1.getString("time"));

    Document doc2 = Document.create("doc2");
    doc2.setField("race", "mile run");
    doc2.setField("time", "223130.0");
    stage.processDocument(doc2);
    assertEquals("223130.0ms", doc2.getString("time"));

    Document doc3 = Document.create("doc3");
    doc3.setField("race", "marathon");
    stage.processDocument(doc3);
    assertEquals(null, doc3.getString("time"));
  }
}
