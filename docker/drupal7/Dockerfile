FROM ubuntu:latest

ENV DEBIAN_FRONTEND noninteractive

# install packages
RUN apt-get update
RUN apt-get install -y apache2 libapache2-mod-php5 php5-mysql php5-gd php-db telnet git drush mysql-client

# download drupal
#RUN cd /var; rm -r www/; drush dl drupal; mv drupal*/ www/
RUN cd /var; rm -r www/; drush dl drupal-7; mv drupal*/ www/
RUN chown -R www-data:www-data /var/www/

ADD start.sh start.sh
RUN chmod +x start.sh

ADD drupal-install-conf.sh drupal-install-conf.sh
RUN chmod +x drupal-install-conf.sh

RUN rm /etc/apache2/sites-available/000-default.conf
ADD 000-default.conf /etc/apache2/sites-available/000-default.conf

# copy sql dump
ADD fab.sql fab.sql
ADD fabdb_drupal7.sql fabdb_drupal7.sql

# copy files -- uncomment it later..
#RUN mkdir /var/www/sites/fablab.fau.de/
#RUN mkdir /var/www/sites/fablab.fau.de/files/
#RUN mkdir /var/www/sites/fablab.fau.de/files/images/
#ADD files/images/* /var/www/sites/fablab.fau.de/files/images/
#RUN chown -R www-data:www-data /var/www/sites/fablab.fau.de/files/

EXPOSE 80

# execute .start.sh and the start bash -- it works!
CMD bash -C './start.sh';'/bin/bash'
