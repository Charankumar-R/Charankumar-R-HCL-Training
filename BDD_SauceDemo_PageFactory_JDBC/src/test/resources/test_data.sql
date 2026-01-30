CREATE TABLE test_data (
    username VARCHAR(50),
    password VARCHAR(50),
	firstname VARCHAR(50),
    lastname VARCHAR(50),
    zipcode VARCHAR(50),
    is_active INT
);

INSERT INTO test_data VALUES
('standard_user', 'secret_sauce', 'Charankumar', 'R', '631001', 1),
('locked_out_user', 'secret_sauce', 'Charankumar', 'R', '631001', 1),
('problem_user', 'secret_sauce', 'Charankumar', 'R', '631001', 1),
('performance_glitch_user', 'secret_sauce', 'Charankumar', 'R', '631001', 1),
('error_user', 'secret_sauce', 'Charankumar', 'R', '631001', 1),
('visual_user', 'secret_sauce', 'Charankumar', 'R', '631001', 1);
