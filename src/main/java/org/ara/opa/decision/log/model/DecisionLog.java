package org.ara.opa.decision.log.model;

import io.vertx.core.spi.metrics.Metrics;
import org.eclipse.microprofile.config.inject.ConfigProperty;

public class DecisionLog {
    Labels labels;

    @ConfigProperty(name = "decision_id")
    String decisionId;
    String revision;

    Bundles bundles;

    String path;
    String query;

    Input input;
    Boolean result;

    @ConfigProperty(name = "requested_by")
    String requestedBy;

    String timestamp;

    Metrics metrics;
    String[] erased;
}

