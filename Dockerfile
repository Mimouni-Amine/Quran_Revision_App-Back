# Use an official OpenJDK runtime as the base image
FROM openjdk:17-oracle

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy the JAR file (you should have built it already) to the working directory
COPY out/artifacts/Quran_Hizb_Revision_App_jar/Quran_Hizb_Revision_App.jar .

# Expose the port your Java app is listening on
EXPOSE 8080

# Define the command to run the Java app
CMD ["java", "-jar", "Quran_Hizb_Revision_App.jar"]