package com.wf.elastic.model;

import org.springframework.data.elasticsearch.annotations.Document;
import java.util.UUID;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("users")
@Entity
@Document(indexName = "users", type = "users", shards = 1)
public class User
{
	@PrimaryKey
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private String zipCode;
}

