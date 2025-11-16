# Start from the official Jenkins LTS image
FROM jenkins/jenkins:lts

# Switch to root user
USER root

# Install Docker CLI
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        docker.io \
        maven \
        ca-certificates \
        curl \
        gnupg \
        lsb-release && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Add Jenkins user to Docker group
RUN usermod -aG docker jenkins

# Pre-install Jenkins plugins
RUN jenkins-plugin-cli --plugins \
    git \
    workflow-aggregator \
    docker-workflow \
    sonar \
    sonar-quality-gates \
    nexus-artifact-uploader \
    credentials-binding \
    config-file-provider \
    pipeline-utility-steps

# Switch back to Jenkins user
USER jenkins
