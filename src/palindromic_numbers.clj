(ns palindromic_numbers)

(defn pal-num [n]
  (let [s (str n)
        length (count s)
        half (subs s 0 (Math/ceil (/ length 2)))
        next-half (str (inc (read-string half)))
        next-pal (first
                   (filter #(>= % n)
                     (map #(read-string (str %
                                            (subs (clojure.string/reverse %) (if (even? length) 0 1))))
                          [half next-half])
                     )
                 )]
    (cons next-pal (lazy-seq (pal-num (inc next-pal)))))
)
