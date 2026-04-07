package com.lucille.example.stage;

import java.util.Iterator;

import com.kmwllc.lucille.core.ConfigUtils;
import com.kmwllc.lucille.core.Document;
import com.kmwllc.lucille.core.Stage;
import com.kmwllc.lucille.core.StageException;
import com.kmwllc.lucille.core.spec.Spec;
import com.kmwllc.lucille.core.spec.SpecBuilder;
import com.typesafe.config.Config;

/**
 * Adds units to a given field, either at the beginning or end of the value.
 * <br>
 * Config Parameters -
 * <br>
 * dest (String) : The field to place the unit on
 * unit (String) : Unit that you want to add, ex. 'ms' for milliseconds
 * after (boolean, Optional) : Should the unit be placed at the end of the value, beginning if false
 */
public class AddUnitsStage extends Stage {
  private final String dest;
  private final String unit;
  private final boolean after;

  // Specifying which properties are required / optional for the Stage's configuration.
  // This allows Lucille to validate Config files that use this Stage, reporting errors if
  // - A required property is missing
  // - An unknown property is used in the Config
  public static final Spec SPEC = SpecBuilder.stage()
    .withRequiredProperties("dest", "unit")
    .withOptionalProperties("after").build();

  public AddUnitsStage(Config config) {
    super(config);

    this.dest = config.getString("dest");
    this.unit = config.getString("unit");
    this.after = ConfigUtils.getOrDefault(config, "after", true);
  }

  @Override
  public Iterator<Document> processDocument(Document doc) throws StageException {
    String newVal = doc.getString(dest);
    if (newVal != null) {
      if (this.after) {
        newVal += this.unit;
      } else {
        newVal = this.unit + newVal;
      }
      doc.setField(dest, newVal);
    }

    return null;
  }
}