
create table revision (
                      id serial not null,
                      quarter_number numeric not null,
                      mastery varchar(50),
                      time_updated date,
                      urgency boolean default false,
                      primary key (id)
                      --date added maybe
);