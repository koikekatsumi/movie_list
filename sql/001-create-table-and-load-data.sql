DROP TABLE IF EXISTS movies;

CREATE TABLE movies
(
  id INT UNSIGNED AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  release_date DATE NOT NULL,
  lead_actor VARCHAR(100) NOT NULL,
  box_office INT NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO movies (name, release_date, lead_actor, box_office)VALUES ('ホーム　アローン', '1991-06-22', 'マコーレ　カルキン', 476684675);
INSERT INTO movies (name, release_date, lead_actor, box_office)VALUES ('タイタニック','1997-12-20','レオナルド　ディカプリオ', 658532551);
INSERT INTO movies (name, release_date, lead_actor, box_office)VALUES ('メリーに首ったけ','1999-01-30','キャメロン　ディアス', 369884651);
INSERT INTO movies (name, release_date, lead_actor, box_office)VALUES ('バック　トゥ　ザ　フューチャー','1985-12-07','マイケル　J　フォックス', 210609762);

