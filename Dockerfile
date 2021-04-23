# syntax=docker/dockerfile:1
FROM findepi/graalvm

RUN apt update
RUN apt install build-essential -y
RUN apt-get install libz-dev -y

RUN gu install native-image

CMD cd /app && native-image --report-unsupported-elements-at-runtime \
             --initialize-at-build-time \
             --no-server \
             -jar ./target/sotify-0.1.0-SNAPSHOT-standalone.jar \
             -H:Name=./target/sotify
