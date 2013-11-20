(ns levenshtein_distance)

(defn distance [str1 str2]
  (let [len1 (count str1)
        len2 (count str2)
        match (= (first str1) (first str2))]
    (cond (zero? len1) len2
          (zero? len2) len1
          (true? match) (distance (rest str1) (rest str2))
          :else (min (inc (distance (rest str1) str2))
                     (inc (distance str1 (rest str2)))
                     (inc (distance (rest str1) (rest str2)))))))