FROM node:10 AS ui-build
WORKDIR /usr/src/app
COPY webApp/ ./webApp/
RUN cd webApp && npm install && npm run build

FROM node:10 AS server-build
WORKDIR /root/
COPY --from=ui-build /usr/src/app/webApp/build ./webApp/build
COPY api/package*.json ./api/
RUN cd api && npm install
COPY api/server.js ./api/

EXPOSE 3080

CMD ["node", "./api/server.js"]