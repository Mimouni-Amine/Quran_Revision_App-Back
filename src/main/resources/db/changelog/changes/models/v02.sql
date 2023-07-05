
create table log_Revised (
                             id serial not null,
                             quarter_number numeric not null,
                             mastery varchar(50),
                             time_revised date,
                             primary key (id)
)
