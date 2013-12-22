(ns latin_square_slicing)

(defn latin-square? [square]
  (let [rows (identity square)
        columns (reduce #(map flatten (map vector %1 %2)) rows)
        distinct-elements (map #(distinct %) (concat rows columns))
        distinct-square-elements (reduce #(apply conj %1 %2) #{} distinct-elements)]
    (apply = (conj (map #(count %) distinct-elements)
                   (count square)
                   (count (first square))
                   (count distinct-square-elements)))
  )
)

(defn process [vectors]
  (let [rows (identity vectors)
        columns (reduce #(map flatten (map vector %1 %2)) rows)]
    {}
  )
)
