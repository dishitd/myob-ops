FROM nginx:latest

EXPOSE 8080

# Copy nginx.conf to nginx docker container
COPY nginx.conf /etc/nginx/nginx.conf

# nginx start
CMD ["nginx", "-g", "daemon off;"]