package org.unicodetool.graphql.schema;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.unicodetool.application.CodepointQueryHandler;
import org.unicodetool.application.exceptions.CodepointNotFound;

import java.util.Arrays;
import java.util.List;

@Component
public class Query implements GraphQLRootResolver {

    private final CodepointQueryHandler codepointQueryHandler;

    @Autowired
    public Query(CodepointQueryHandler cqh) {
        this.codepointQueryHandler = cqh;
    }

    public Codepoint codepoint(CodepointValue codepointValue) {
        return codepointQueryHandler
                .findCodepoint(codepointValue)
                .orElseThrow(CodepointNotFound::new);
    }

    public List<Codepoint> codepoints() {
        Codepoint c1 = new Codepoint(
                CodepointValue.of(0x41),
                "LATIN CAPITAL LETTER A",
                new Properties(
                        "LATIN CAPITAL LETTER A",
                        "Basic Latin"
                )
        );
        Codepoint c2 = new Codepoint(
                CodepointValue.of(0x42),
                "LATIN CAPITAL LETTER B",
                new Properties(
                        "LATIN CAPITAL LETTER B",
                        "Basic Latin"
                )
        );
        Codepoint c3 = new Codepoint(
                CodepointValue.of(0x43),
                "LATIN CAPITAL LETTER C",
                new Properties(
                        "LATIN CAPITAL LETTER C",
                        "Basic Latin"
                )
        );

        return Arrays.asList(c1, c2, c3);
    }
}
