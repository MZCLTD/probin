package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class ObjectWorkflowState implements Serializable {

    @JsonProperty("State")
    @JsonIgnoreProperties
    private PropertyValue state;

    @JsonProperty("StateID")
    @JsonIgnoreProperties
    private int stateID;

    @JsonProperty("StateName")
    @JsonIgnoreProperties
    private String stateName;

    @JsonProperty("Workflow")
    @JsonIgnoreProperties
    private PropertyValue workflow;

    @JsonProperty("WorkflowID")
    @JsonIgnoreProperties
    private int workflowID;

    @JsonProperty("WorkflowName")
    @JsonIgnoreProperties
    private String workflowName;

    @JsonProperty("VersionComment")
    @JsonIgnoreProperties
    private String versionComment;
    
    @JsonProperty("HasState")
    private boolean hasState;
    
    @JsonProperty("StateHidden")
    @JsonIgnoreProperties
    private boolean stateHidden;
    
    @JsonProperty("HasWorkflow")
    @JsonIgnoreProperties
    private boolean hasWorkflow;
    
    @JsonProperty("WorkflowHidden")
    @JsonIgnoreProperties
    private boolean workflowHidden;

    public ObjectWorkflowState() {}

    public PropertyValue getState() {
        return state;
    }

    public void setState(PropertyValue state) {
        this.state = state;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public PropertyValue getWorkflow() {
        return workflow;
    }

    public void setWorkflow(PropertyValue workflow) {
        this.workflow = workflow;
    }

    public int getWorkflowID() {
        return workflowID;
    }

    public void setWorkflowID(int workflowID) {
        this.workflowID = workflowID;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getVersionComment() {
        return versionComment;
    }

    public void setVersionComment(String versionComment) {
        this.versionComment = versionComment;
    }

	public boolean isHasState() {
		return hasState;
	}

	public void setHasState(boolean hasState) {
		this.hasState = hasState;
	}

	public boolean isStateHidden() {
		return stateHidden;
	}

	public void setStateHidden(boolean stateHidden) {
		this.stateHidden = stateHidden;
	}

	public boolean isHasWorkflow() {
		return hasWorkflow;
	}

	public void setHasWorkflow(boolean hasWorkflow) {
		this.hasWorkflow = hasWorkflow;
	}

	public boolean isWorkflowHidden() {
		return workflowHidden;
	}

	public void setWorkflowHidden(boolean workflowHidden) {
		this.workflowHidden = workflowHidden;
	}
}
