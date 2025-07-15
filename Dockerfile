FROM amazoncorretto:17-alpine-jdk AS build

WORKDIR /app

COPY . .

RUN apk add --no-cache bash curl zip unzip

RUN chmod +x ./gradlew

RUN ./gradlew build -x test

FROM amazoncorretto:17-alpine AS runtime

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENV TZ="America/Lima"
ENV JAVA_OPTS="-Xmx512m -Duser.timezone=America/Lima"
ENV SPRING_OPTS="--spring.profiles.active=prod"

CMD ["sh", "-c", "java -jar app.jar ${JAVA_OPTS} ${SPRING_OPTS}"]