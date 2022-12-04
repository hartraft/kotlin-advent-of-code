CREATE TABLE if not exists public.aoc_day04 (
        "input" varchar NULL
);

INSERT INTO public.aoc_day04 ("input") VALUES('2-4,6-8');
INSERT INTO public.aoc_day04 ("input") VALUES('2-3,4-5');
INSERT INTO public.aoc_day04 ("input") VALUES('5-7,7-9');
INSERT INTO public.aoc_day04 ("input") VALUES('2-8,3-7');
INSERT INTO public.aoc_day04 ("input") VALUES('6-6,4-6');
INSERT INTO public.aoc_day04 ("input") VALUES('2-6,4-8');

--WITH checks AS (
select input,
        ('['||replace(split_part(input, ',', 1), '-', ',')||']')::int4range as "First pair",
        ('['||replace(split_part(input, ',', 2), '-', ',')||']')::int4range as "Second pair",
        (('['||replace(split_part(input, ',', 1), '-', ',')||']')::int4range @> ('['||replace(split_part(input, ',', 2), '-', ',')||']')::int4range) OR
        (('['||replace(split_part(input, ',', 2), '-', ',')||']')::int4range @> ('['||replace(split_part(input, ',', 1), '-', ',')||']')::int4range) pt1, 
        ('['||replace(split_part(input, ',', 1), '-', ',')||']')::int4range *
        ('['||replace(split_part(input, ',', 2), '-', ',')||']')::int4range pt2
        from aoc_day04;
--)
/*
select sum(pt1) as "Intersection part 1",
	sum(pt2) as "Intersection part 2"
	from checks;
*/
--select * from aoc_day04 ad ;
