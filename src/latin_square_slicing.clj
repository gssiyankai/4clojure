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
  (let [order (count vectors)
        rows (identity vectors)
        columns (reduce #(map flatten (map vector %1 %2)) rows)]
    (->> (for [o (range 2 (inc order))
               x1 (range order)
               y1 (range order)
               :let [x2 (+ x1 o)
                     y2 (+ y1 o)]
               :when (and (< x2 (inc order))
                          (< y2 (inc order)))]
           (let [square (map #(subvec % x1 x2) (subvec vectors y1 y2))]
             (if (latin-square? square) square nil)
           ))
         (filter #(not (nil? %)))
         (group-by #(count %))
         (map #(vector (key %) (count (val %))))
         (into {})
    )
  )
)
