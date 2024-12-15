# Use the official Gradle image from the Docker Hub
FROM gradle:8.7.0-jdk21

# Set the working directory
WORKDIR /project

# Install make
RUN apt-get update && apt-get install -yq make

# Create the code directory
RUN mkdir /project/code

# Copy the project files into the container
COPY . .

# Change permissions for gradlew
RUN chmod +x /project/code/gradlew

# Set the default command to run when the container starts
CMD ["make", "setup"]