package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@JsonFilter("propertyType")
@XmlRootElement
@XmlType(propOrder = {"id", "uri", "context", "propertyUri", "localName", "type", "prefLabel", "definition"})
@ApiModel(value = "PropertyType", description = "PropertyType model for data relation typing.")
public class PropertyTypeDTO extends AbstractIdentifyableCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String uri;
    private String propertyUri;
    private String localName;
    private String context;
    private String type;
    private Map<String, String> prefLabel;
    private Map<String, String> definition;

    @JsonView(Views.Normal.class)
    public String getLocalName() {
        return localName;
    }

    public void setLocalName(final String localName) {
        this.localName = localName;
    }

    @JsonView(Views.Normal.class)
    public String getContext() {
        return context;
    }

    public void setContext(final String context) {
        this.context = context;
    }

    @JsonView(Views.Normal.class)
    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @JsonView(Views.Normal.class)
    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    @JsonView(Views.Normal.class)
    public String getPropertyUri() {
        return propertyUri;
    }

    public void setPropertyUri(final String propertyUri) {
        this.propertyUri = propertyUri;
    }

    @JsonView(Views.Normal.class)
    public Map<String, String> getPrefLabel() {
        if (prefLabel == null) {
            prefLabel = new HashMap<>();
        }
        return prefLabel;
    }

    public void setPrefLabel(final Map<String, String> prefLabel) {
        this.prefLabel = prefLabel;
    }

    public String getPrefLabel(final String language) {
        String prefLabelValue = this.prefLabel.get(language);
        if (prefLabelValue == null) {
            prefLabelValue = this.prefLabel.get(LANGUAGE_CODE_EN);
        }
        return prefLabelValue;
    }

    public void setPrefLabel(final String language, final String value) {
        if (prefLabel == null) {
            prefLabel = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            prefLabel.put(language, value);
        } else if (language != null) {
            prefLabel.remove(language);
        }
        setPrefLabel(prefLabel);
    }

    @JsonView(Views.Normal.class)
    public Map<String, String> getDefinition() {
        if (definition == null) {
            definition = new HashMap<>();
        }
        return definition;
    }

    public void setDefinition(final Map<String, String> definition) {
        this.definition = definition;
    }

    public String getDefinition(final String language) {
        String definitionValue = this.definition.get(language);
        if (definitionValue == null) {
            definitionValue = this.definition.get(LANGUAGE_CODE_EN);
        }
        return definitionValue;
    }

    public void setDefinition(final String language, final String value) {
        if (definition == null) {
            definition = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            definition.put(language, value);
        } else if (language != null) {
            definition.remove(language);
        }
        setDefinition(definition);
    }
}