(ns levenshtein_distance)

(defn distance [str1 str2]
  (let [f (fn [lev str1 str2]
            (let [len1 (count str1)
                  len2 (count str2)
                  match (= (first str1) (first str2))]
              (cond (zero? len1) len2
                (zero? len2) len1
                (true? match) (lev lev (rest str1) (rest str2))
                :else (min (inc (lev lev (rest str1) str2))
                        (inc (lev lev str1 (rest str2)))
                        (inc (lev lev (rest str1) (rest str2)))))))]
    (f (memoize f) (vec str1) (vec str2)))
)