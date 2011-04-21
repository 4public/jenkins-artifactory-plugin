package org.jfrog.hudson.util;

import org.apache.commons.lang.StringUtils;
import org.jfrog.hudson.DeployerOverrider;
import org.jfrog.hudson.ServerDetails;

/**
 * Container class for build context fields
 *
 * @author Tomer Cohen
 */
public class BuildContext {

    private final ServerDetails details;
    private final DeployerOverrider deployerOverrider;
    private final boolean runChecks;
    private final boolean includePublishArtifacts;
    private final String violationRecipients;
    private final String scopes;
    private final boolean licenseAutoDiscovery;
    private final boolean discardOldBuilds;
    private final boolean discardBuildArtifacts;
    private final boolean deployArtifacts;
    private final IncludesExcludes includesExcludes;
    private final boolean skipBuildInfoDeploy;
    private final boolean includeEnvVars;
    private boolean evenIfUnstable;
    private boolean deployMaven;
    private boolean deployIvy;
    private String artifactsPattern = "";
    private String ivyPattern = "";

    public BuildContext(ServerDetails details, DeployerOverrider deployerOverrider, boolean runChecks,
            boolean includePublishArtifacts, String violationRecipients, String scopes, boolean licenseAutoDiscovery,
            boolean discardOldBuilds, boolean deployArtifacts, IncludesExcludes includesExcludes,
            boolean skipBuildInfoDeploy, boolean includeEnvVars, boolean discardBuildArtifacts) {
        this.details = details;
        this.deployerOverrider = deployerOverrider;
        this.runChecks = runChecks;
        this.includePublishArtifacts = includePublishArtifacts;
        this.violationRecipients = violationRecipients;
        this.scopes = scopes;
        this.licenseAutoDiscovery = licenseAutoDiscovery;
        this.discardOldBuilds = discardOldBuilds;
        this.deployArtifacts = deployArtifacts;
        this.includesExcludes = includesExcludes;
        this.skipBuildInfoDeploy = skipBuildInfoDeploy;
        this.includeEnvVars = includeEnvVars;
        this.discardBuildArtifacts = discardBuildArtifacts;
    }

    public String getArtifactsPattern() {
        return getCleanString(artifactsPattern);
    }

    public void setArtifactsPattern(String artifactsPattern) {
        this.artifactsPattern = artifactsPattern;
    }

    public String getIvyPattern() {
        return getCleanString(ivyPattern);
    }

    public boolean isDiscardBuildArtifacts() {
        return discardBuildArtifacts;
    }

    public void setIvyPattern(String ivyPattern) {
        this.ivyPattern = ivyPattern;
    }

    public ServerDetails getDetails() {
        return details;
    }

    public IncludesExcludes getIncludesExcludes() {
        return includesExcludes;
    }

    public boolean isSkipBuildInfoDeploy() {
        return skipBuildInfoDeploy;
    }

    public boolean isIncludeEnvVars() {
        return includeEnvVars;
    }

    public DeployerOverrider getDeployerOverrider() {
        return deployerOverrider;
    }

    public String getScopes() {
        return scopes;
    }

    public boolean isRunChecks() {
        return runChecks;
    }

    public boolean isIncludePublishArtifacts() {
        return includePublishArtifacts;
    }

    public String getViolationRecipients() {
        return violationRecipients;
    }

    public boolean isLicenseAutoDiscovery() {
        return licenseAutoDiscovery;
    }

    public boolean isDiscardOldBuilds() {
        return discardOldBuilds;
    }

    public boolean isDeployArtifacts() {
        return deployArtifacts;
    }

    public final String getArtifactoryName() {
        return details != null ? details.artifactoryName : null;
    }

    public boolean isDeployMaven() {
        return deployMaven;
    }

    public void setDeployMaven(boolean deployMaven) {
        this.deployMaven = deployMaven;
    }

    public boolean isDeployIvy() {
        return deployIvy;
    }

    public void setDeployIvy(boolean deployIvy) {
        this.deployIvy = deployIvy;
    }

    public boolean isEvenIfUnstable() {
        return evenIfUnstable;
    }

    public void setEvenIfUnstable(boolean evenIfUnstable) {
        this.evenIfUnstable = evenIfUnstable;
    }

    private String getCleanString(String stringToClean) {
        return StringUtils.removeEnd(StringUtils.removeStart(stringToClean, "\""), "\"");
    }
}
