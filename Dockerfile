FROM hseeberger/scala-sbt

WORKDIR /play-async

COPY ./.git /play-async/.git/

COPY ./build.sbt /play-async

COPY ./bintray.sbt /play-async

COPY ./LICENSE /play-async

COPY ./project/*.sbt /play-async/project/

COPY ./project/*.scala /play-async/project/

COPY ./src /play-async/src/

RUN sbt test

CMD ["sbt", "publishLocal"]
